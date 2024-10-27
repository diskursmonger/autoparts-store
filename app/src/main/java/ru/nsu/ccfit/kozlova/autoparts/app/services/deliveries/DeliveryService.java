package ru.nsu.ccfit.kozlova.autoparts.app.services.deliveries;

import retrofit2.Call;
import retrofit2.http.*;
import ru.nsu.ccfit.kozlova.autoparts.app.model.deliveries.CustomRequest;
import ru.nsu.ccfit.kozlova.autoparts.app.model.deliveries.DeliveryCreateRequest;
import ru.nsu.ccfit.kozlova.autoparts.app.model.deliveries.DeliveryDto;
import ru.nsu.ccfit.kozlova.autoparts.app.model.deliveries.DeliveryUpdateRequest;
import ru.nsu.ccfit.kozlova.autoparts.app.services.crud.AbstractCrudService;
import ru.nsu.ccfit.kozlova.autoparts.app.services.crud.ServiceResponse;

public class DeliveryService extends AbstractCrudService<DeliveryDto, DeliveryCreateRequest, DeliveryUpdateRequest> {

	private final DeliveryServiceApi deliveryServiceApi;

	public DeliveryService(String baseUrl) {
		super(DeliveryServiceApi.class, DeliveryDto.class, baseUrl, "deliveries");
		deliveryServiceApi = (DeliveryServiceApi) getServiceApi();
	}

	public ServiceResponse<DeliveryDto> addDetail(Long deliveryId, Long detailId) {
		var call = deliveryServiceApi.addDetail(deliveryId, detailId);
		return getServerResponse(call);
	}

	public ServiceResponse<Void> deleteDetail(Long deliveryId, Long detailId) {
		var call = deliveryServiceApi.deleteDetail(deliveryId, detailId);
		return getServerResponse(call);
	}

	public ServiceResponse<DeliveryDto> setDetailTypePrice(Long deliveryId, Long detailTypeId, Double price) {
		var call = deliveryServiceApi.setDetailTypePrice(deliveryId, detailTypeId, price);
		return getServerResponse(call);
	}

	public ServiceResponse<Void> deleteDetailTypePrice(Long deliveryId, Long detailTypeId) {
		var call = deliveryServiceApi.deleteDetailTypePrice(deliveryId, detailTypeId);
		return getServerResponse(call);
	}

	public ServiceResponse<Void> setCustom(Long deliveryId, CustomRequest customRequest) {
		var call = deliveryServiceApi.setCustom(deliveryId, customRequest);
		return getServerResponse(call);
	}

}
