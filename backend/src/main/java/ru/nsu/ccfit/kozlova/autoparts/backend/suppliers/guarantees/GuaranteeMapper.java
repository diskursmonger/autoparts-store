package ru.nsu.ccfit.kozlova.autoparts.backend.suppliers.guarantees;

import org.springframework.stereotype.Component;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.details.types.DetailTypeDto;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.suppliers.guarantees.GuaranteeCreateRequest;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.suppliers.guarantees.GuaranteeDto;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.suppliers.guarantees.GuaranteeUpdateRequest;
import ru.nsu.ccfit.kozlova.autoparts.backend.crud.data.Mapper;
import ru.nsu.ccfit.kozlova.autoparts.backend.details.types.DetailType;
import ru.nsu.ccfit.kozlova.autoparts.backend.details.types.DetailTypeMapper;
import ru.nsu.ccfit.kozlova.autoparts.backend.details.types.DetailTypeRepository;
import ru.nsu.ccfit.kozlova.autoparts.backend.suppliers.Supplier;
import ru.nsu.ccfit.kozlova.autoparts.backend.suppliers.SupplierRepository;
import static ru.nsu.ccfit.kozlova.autoparts.backend.crud.data.MapperUtils.setIfNotNull;

@Component
public class GuaranteeMapper implements Mapper<
		Guarantee, GuaranteeDto, GuaranteeCreateRequest, GuaranteeUpdateRequest> {

	private final SupplierRepository supplierRepository;
	private final DetailTypeRepository detailTypeRepository;
	private final DetailTypeMapper detailTypeMapper;

	public GuaranteeMapper(
			SupplierRepository supplierRepository,
			DetailTypeRepository detailTypeRepository,
			DetailTypeMapper detailTypeMapper
	) {
		this.supplierRepository = supplierRepository;
		this.detailTypeRepository = detailTypeRepository;
		this.detailTypeMapper = detailTypeMapper;
	}

	@Override
	public Guarantee createEntity(GuaranteeCreateRequest createRequest) {
		Supplier supplier = supplierRepository.getById(createRequest.getSupplierId());
		DetailType detailType = detailTypeRepository.getById(createRequest.getDetailTypeId());
		return Guarantee.builder()
				.guaranteeMonths(createRequest.getGuaranteeMonths())
				.supplier(supplier)
				.detailType(detailType)
				.build();
	}

	@Override
	public void updateEntity(Guarantee guarantee, GuaranteeUpdateRequest updateRequest) {
		setIfNotNull(updateRequest.getGuaranteeMonths(), guarantee::setGuaranteeMonths);
		setIfNotNull(updateRequest.getDetailTypeId(), detailTypeId -> {
			DetailType detailType = detailTypeRepository.getById(detailTypeId);
			guarantee.setDetailType(detailType);
		});
	}

	@Override
	public GuaranteeDto toDto(Guarantee guarantee) {
		DetailTypeDto detailType = detailTypeMapper.toDto(guarantee.getDetailType());
		return GuaranteeDto.builder()
				.id(guarantee.getId())
				.supplierId(guarantee.getId())
				.detailType(detailType)
				.guaranteeMonths(guarantee.getGuaranteeMonths())
				.build();
	}
}
