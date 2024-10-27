package ru.nsu.ccfit.kozlova.autoparts.app.services.details;

import ru.nsu.ccfit.kozlova.autoparts.app.model.details.*;
import ru.nsu.ccfit.kozlova.autoparts.app.services.crud.AbstractCrudService;
import ru.nsu.ccfit.kozlova.autoparts.app.services.crud.ServiceResponse;
import ru.nsu.ccfit.kozlova.autoparts.app.services.deliveries.DeliveryServiceApi;

public class DetailService extends AbstractCrudService<DetailDto, DetailCreateRequest, DetailUpdateRequest> {

	private final DetailServiceApi detailServiceApi;

	public DetailService(String baseUrl) {
		super(DetailServiceApi.class, DetailDto.class, baseUrl, "details");
		detailServiceApi = (DetailServiceApi) getServiceApi();
	}

	public ServiceResponse<RefundDto> makeRefund(Long detailId, RefundRequest refundRequest) {
		var call = detailServiceApi.makeRefund(detailId, refundRequest);
		return getServerResponse(call);
	}

}
