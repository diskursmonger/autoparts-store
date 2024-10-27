package ru.nsu.ccfit.kozlova.autoparts.backend.details;

import org.springframework.stereotype.Component;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.details.DetailCreateRequest;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.details.DetailDto;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.details.DetailUpdateRequest;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.details.RefundDto;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.details.types.DetailTypeDto;
import ru.nsu.ccfit.kozlova.autoparts.backend.crud.data.Mapper;
import ru.nsu.ccfit.kozlova.autoparts.backend.deliveries.Delivery;
import ru.nsu.ccfit.kozlova.autoparts.backend.deliveries.DeliveryRepository;
import ru.nsu.ccfit.kozlova.autoparts.backend.details.storage.StorageCell;
import ru.nsu.ccfit.kozlova.autoparts.backend.details.storage.StorageCellRepository;
import ru.nsu.ccfit.kozlova.autoparts.backend.details.types.DetailType;
import ru.nsu.ccfit.kozlova.autoparts.backend.details.types.DetailTypeMapper;
import ru.nsu.ccfit.kozlova.autoparts.backend.details.types.DetailTypeRepository;

import java.util.Optional;

import static ru.nsu.ccfit.kozlova.autoparts.backend.crud.data.MapperUtils.setIfNotNull;

@Component
public class DetailMapper implements Mapper<Detail, DetailDto, DetailCreateRequest, DetailUpdateRequest> {

	private final DetailTypeMapper detailTypeMapper;
	private final StorageCellRepository storageCellRepository;
	private final DeliveryRepository deliveryRepository;
	private final DetailTypeRepository detailTypeRepository;

	public DetailMapper(
			DetailTypeMapper detailTypeMapper,
			StorageCellRepository storageCellRepository,
			DeliveryRepository deliveryRepository,
			DetailTypeRepository detailTypeRepository
	) {
		this.detailTypeMapper = detailTypeMapper;
		this.storageCellRepository = storageCellRepository;
		this.deliveryRepository = deliveryRepository;
		this.detailTypeRepository = detailTypeRepository;
	}

	@Override
	public Detail createEntity(DetailCreateRequest createRequest) {
		DetailType detailType = detailTypeRepository.getById(createRequest.getDetailTypeId());
		Delivery delivery = deliveryRepository.getById(createRequest.getDeliveryId());
		StorageCell storageCell = storageCellRepository.getById(createRequest.getStorageCellId());

		return Detail.builder()
				.detailType(detailType)
				.cell(storageCell)
				.delivery(delivery)
				.build();
	}

	@Override
	public void updateEntity(Detail detail, DetailUpdateRequest updateRequest) {
		setIfNotNull(updateRequest.getDetailTypeId(), detailTypeId -> {
			DetailType detailType = detailTypeRepository.getById(detailTypeId);
			detail.setDetailType(detailType);
		});
		setIfNotNull(updateRequest.getDeliveryId(), deliveryId -> {
			Delivery delivery = deliveryRepository.getById(deliveryId);
			detail.setDelivery(delivery);
		});

		if (updateRequest.getStorageCellId() == null) {
			detail.setCell(null);
		} else {
			detail.setCell(storageCellRepository.getById(updateRequest.getStorageCellId()));
		}
	}

	@Override
	public DetailDto toDto(Detail detail) {
		RefundDto refund = null;
		Refund refundEntity = detail.getRefund();
		if (refundEntity != null) {
			refund = RefundDto.builder()
					.id(refundEntity.getId())
					.customerRefundDate(refundEntity.getCustomerRefundDate())
					.supplierRefundDate(refundEntity.getSupplierRefundDate())
					.build();
		}

		DetailTypeDto detailType = detailTypeMapper.toDto(detail.getDetailType());
		Long storageCellId = Optional.ofNullable(detail.getCell())
				.map(StorageCell::getId)
				.orElse(null);

		return DetailDto.builder()
				.id(detail.getId())
				.detailType(detailType)
				.deliveryId(detail.getDelivery().getId())
				.storageCellId(storageCellId)
				.refund(refund)
				.build();
	}
}
