package ru.nsu.ccfit.kozlova.autoparts.backend.deliveries;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.deliveries.*;
import ru.nsu.ccfit.kozlova.autoparts.backend.crud.service.AbstractCrudService;
import ru.nsu.ccfit.kozlova.autoparts.backend.details.Detail;
import ru.nsu.ccfit.kozlova.autoparts.backend.details.DetailRepository;
import ru.nsu.ccfit.kozlova.autoparts.backend.details.types.DetailType;
import ru.nsu.ccfit.kozlova.autoparts.backend.details.types.DetailTypeRepository;

@Service
@Transactional
public class DeliveryService extends AbstractCrudService<
		Delivery, DeliveryDto, DeliveryCreateRequest, DeliveryUpdateRequest, Long> {

	private final DeliveryRepository deliveryRepository;
	private final DeliveryMapper deliveryMapper;
	private final DetailRepository detailRepository;
	private final DetailTypeRepository detailTypeRepository;

	public DeliveryService(
			DeliveryRepository deliveryRepository,
			DeliveryMapper deliveryMapper,
			DetailRepository detailRepository,
			DetailTypeRepository detailTypeRepository
	) {
		super(deliveryRepository, deliveryMapper);
		this.deliveryRepository = deliveryRepository;
		this.deliveryMapper = deliveryMapper;
		this.detailRepository = detailRepository;
		this.detailTypeRepository = detailTypeRepository;
	}

	public DeliveryDto addDetail(Long deliveryId, Long detailId) {
		Delivery delivery = getEntityByIdOrThrow(deliveryId);
		Detail detail = getEntityByIdOrThrow(detailRepository, detailId);

		delivery.getDetails().removeIf(d -> d.getId().equals(detailId));
		delivery.getDetails().add(detail);

		return deliveryMapper.toDto(delivery);
	}

	public void deleteDetail(Long deliveryId, Long detailId) {
		Delivery delivery = getEntityByIdOrThrow(deliveryId);
		delivery.getDetails().removeIf(d -> d.getId().equals(detailId));
	}

	public DeliveryDto setDetailTypePrice(Long deliveryId, Long detailTypeId, Double price) {
		Delivery delivery = getEntityByIdOrThrow(deliveryId);
		var deliveryDetailTypePrice = delivery.getDeliveryDetailTypePrices()
				.stream()
				.filter(detailTypePrice -> detailTypePrice.getId().detailTypeId.equals(detailTypeId))
				.findFirst()
				.orElse(null);

		if (deliveryDetailTypePrice != null) {
			delivery.getDeliveryDetailTypePrices().remove(deliveryDetailTypePrice);
		}

		DeliveryDetailTypePrice detailTypePriceToChange = deliveryDetailTypePrice;
		if (detailTypePriceToChange == null) {
			DetailType detailType = getEntityByIdOrThrow(detailTypeRepository, detailTypeId);
			var id = DeliveryDetailTypePrice.DeliveryDetailPriceId
					.builder()
					.deliveryId(deliveryId)
					.detailTypeId(detailTypeId)
					.build();

			detailTypePriceToChange = DeliveryDetailTypePrice.builder()
					.delivery(delivery)
					.detailType(detailType)
					.id(id)
					.build();
		}

		detailTypePriceToChange.setSupplierPrice(price);
		delivery.getDeliveryDetailTypePrices().add(detailTypePriceToChange);

		return deliveryMapper.toDto(delivery);
	}

	public void deleteDetailTypePrice(Long deliveryId, Long detailTypeId) {
		getEntityByIdOrThrow(deliveryId)
				.getDeliveryDetailTypePrices()
				.removeIf(detailTypePrice -> detailTypePrice.getId().detailTypeId.equals(detailTypeId));
	}

	public CustomDto setCustom(Long deliveryId, CustomRequest customRequest) {
		Delivery delivery = getEntityByIdOrThrow(deliveryId);
		Custom custom = Custom.builder()
				.id(deliveryId)
				.delivery(delivery)
				.clearanceDate(customRequest.getClearanceDate())
				.taxPercent(customRequest.getTaxPercent())
				.build();

		delivery.setCustom(custom);
		return CustomDto.builder()
				.id(custom.getId())
				.taxPercent(custom.getTaxPercent())
				.clearanceDate(custom.getClearanceDate())
				.build();
	}

}
