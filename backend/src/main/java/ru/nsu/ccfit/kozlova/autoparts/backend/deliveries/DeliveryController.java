package ru.nsu.ccfit.kozlova.autoparts.backend.deliveries;

import org.springframework.web.bind.annotation.*;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.deliveries.*;
import ru.nsu.ccfit.kozlova.autoparts.backend.crud.controller.AbstractCrudController;

@RestController
@RequestMapping("/deliveries")
public class DeliveryController extends AbstractCrudController<
		DeliveryDto, DeliveryCreateRequest, DeliveryUpdateRequest, Long> {

	private final DeliveryService deliveryService;

	public DeliveryController(DeliveryService deliveryService) {
		super(deliveryService);
		this.deliveryService = deliveryService;
	}

	@PutMapping("/{deliveryId}/details/{detailId}")
	public DeliveryDto addDetail(
			@PathVariable Long deliveryId,
			@PathVariable Long detailId
	) {
		return deliveryService.addDetail(deliveryId, detailId);
	}

	@DeleteMapping("/{deliveryId}/details/{detailId}")
	public void deleteDetail(
			@PathVariable Long deliveryId,
			@PathVariable Long detailId
	) {
		deliveryService.deleteDetail(deliveryId, detailId);
	}

	@PutMapping("/{deliveryId}/prices/{detailTypeId}")
	public DeliveryDto setDetailTypePrice(
			@PathVariable Long deliveryId,
			@PathVariable Long detailTypeId,
			@RequestParam Double price
	) {
		return deliveryService.setDetailTypePrice(deliveryId, detailTypeId, price);
	}

	@DeleteMapping("/{deliveryId}/prices/{detailTypeId}")
	public void deleteDetailTypePrice(
			@PathVariable Long deliveryId,
			@PathVariable Long detailTypeId
	) {
		deliveryService.deleteDetailTypePrice(deliveryId, detailTypeId);
	}

	@PutMapping("/{deliveryId}/custom")
	public CustomDto setCustom(@PathVariable Long deliveryId, @RequestBody CustomRequest customRequest) {
		return deliveryService.setCustom(deliveryId, customRequest);
	}

}
