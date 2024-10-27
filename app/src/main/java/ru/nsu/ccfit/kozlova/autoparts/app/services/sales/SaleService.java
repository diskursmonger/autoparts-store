package ru.nsu.ccfit.kozlova.autoparts.app.services.sales;

import ru.nsu.ccfit.kozlova.autoparts.app.model.sales.SaleCreateRequest;
import ru.nsu.ccfit.kozlova.autoparts.app.model.sales.SaleDto;
import ru.nsu.ccfit.kozlova.autoparts.app.model.sales.SaleUpdateRequest;
import ru.nsu.ccfit.kozlova.autoparts.app.services.crud.AbstractCrudService;
import ru.nsu.ccfit.kozlova.autoparts.app.services.crud.ServiceResponse;

public class SaleService extends AbstractCrudService<SaleDto, SaleCreateRequest, SaleUpdateRequest> {

	private final SaleServiceApi saleServiceApi;

	public SaleService(String baseUrl) {
		super(SaleServiceApi.class, SaleDto.class, baseUrl, "sales");
		saleServiceApi = (SaleServiceApi) getServiceApi();
	}

	public ServiceResponse<SaleDto> addDetail(Long saleId, Long detailId) {
		var call = saleServiceApi.addDetail(saleId, detailId);
		return getServerResponse(call);
	}

	public ServiceResponse<Void> deleteDetail(Long saleId, Long detailId) {
		var call = saleServiceApi.deleteDetail(saleId, detailId);
		return getServerResponse(call);
	}

}
