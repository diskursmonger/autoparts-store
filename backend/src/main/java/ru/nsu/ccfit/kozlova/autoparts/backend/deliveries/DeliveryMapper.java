package ru.nsu.ccfit.kozlova.autoparts.backend.deliveries;

import org.springframework.stereotype.Component;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.deliveries.*;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.details.DetailDto;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.suppliers.SupplierDto;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.suppliers.guarantees.GuaranteeDto;
import ru.nsu.ccfit.kozlova.autoparts.backend.crud.data.Mapper;
import ru.nsu.ccfit.kozlova.autoparts.backend.details.DetailMapper;
import ru.nsu.ccfit.kozlova.autoparts.backend.details.types.DetailTypeMapper;
import ru.nsu.ccfit.kozlova.autoparts.backend.suppliers.Supplier;
import ru.nsu.ccfit.kozlova.autoparts.backend.suppliers.SupplierRepository;
import ru.nsu.ccfit.kozlova.autoparts.backend.suppliers.guarantees.GuaranteeMapper;
import static ru.nsu.ccfit.kozlova.autoparts.backend.crud.data.MapperUtils.setIfNotNull;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class DeliveryMapper implements Mapper<
		Delivery, DeliveryDto, DeliveryCreateRequest, DeliveryUpdateRequest> {

	private final DetailTypeMapper detailTypeMapper;
	private final DetailMapper detailMapper;
	private final GuaranteeMapper guaranteeMapper;
	private final SupplierRepository supplierRepository;

	public DeliveryMapper(
			DetailTypeMapper detailTypeMapper,
			DetailMapper detailMapper,
			GuaranteeMapper guaranteeMapper,
			SupplierRepository supplierRepository
	) {
		this.detailTypeMapper = detailTypeMapper;
		this.detailMapper = detailMapper;
		this.guaranteeMapper = guaranteeMapper;
		this.supplierRepository = supplierRepository;
	}

	@Override
	public Delivery createEntity(DeliveryCreateRequest createRequest) {
		Supplier supplier = supplierRepository.getById(createRequest.getSupplierId());
		return Delivery.builder()
				.discountPercent(createRequest.getDiscountPercent())
				.deliveryDate(createRequest.getDeliveryDate())
				.formationDate(createRequest.getFormationDate())
				.supplier(supplier)
				.build();
	}

	@Override
	public void updateEntity(Delivery delivery, DeliveryUpdateRequest updateRequest) {
		setIfNotNull(updateRequest.getDiscountPercent(), delivery::setDiscountPercent);
		setIfNotNull(updateRequest.getDeliveryDate(), delivery::setDeliveryDate);
		setIfNotNull(updateRequest.getFormationDate(), delivery::setFormationDate);
		setIfNotNull(updateRequest.getSupplierId(), supplierId -> {
			Supplier supplier = supplierRepository.getById(supplierId);
			delivery.setSupplier(supplier);
		});
	}

	@Override
	public DeliveryDto toDto(Delivery delivery) {
		Set<DeliveryDetailTypePriceDto> detailTypePrices = delivery.getDeliveryDetailTypePrices()
				.stream()
				.map(dtp -> DeliveryDetailTypePriceDto.builder()
							.detailType(detailTypeMapper.toDto(dtp.getDetailType()))
							.price(dtp.getSupplierPrice())
							.build()
				).collect(Collectors.toSet());

		Set<DetailDto> details = delivery.getDetails()
				.stream()
				.map(detailMapper::toDto)
				.collect(Collectors.toSet());

		Supplier supplierEntity = delivery.getSupplier();
		Set<GuaranteeDto> guarantees = supplierEntity.getGuarantees()
				.stream()
				.map(guaranteeMapper::toDto)
				.collect(Collectors.toSet());

		SupplierDto supplier = SupplierDto.builder()
				.id(supplierEntity.getId())
				.name(supplierEntity.getName())
				.guarantees(guarantees)
				.build();

		CustomDto custom = null;
		Custom customEntity = delivery.getCustom();
		if (customEntity != null) {
			custom = CustomDto.builder()
					.id(customEntity.getId())
					.clearanceDate(customEntity.getClearanceDate())
					.taxPercent(customEntity.getTaxPercent())
					.build();
		}

		return DeliveryDto.builder()
				.id(delivery.getId())
				.deliveryDate(delivery.getDeliveryDate())
				.formationDate(delivery.getFormationDate())
				.discountPercent(delivery.getDiscountPercent())
				.supplier(supplier)
				.custom(custom)
				.detailTypePrices(detailTypePrices)
				.details(details)
				.build();
	}
}
