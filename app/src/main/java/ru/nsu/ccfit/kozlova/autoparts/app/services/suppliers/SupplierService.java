package ru.nsu.ccfit.kozlova.autoparts.app.services.suppliers;

import ru.nsu.ccfit.kozlova.autoparts.app.model.suppliers.SupplierDto;
import ru.nsu.ccfit.kozlova.autoparts.app.model.suppliers.guarantees.GuaranteeDto;
import ru.nsu.ccfit.kozlova.autoparts.app.services.crud.AbstractCrudService;
import ru.nsu.ccfit.kozlova.autoparts.app.services.crud.AbstractService;
import ru.nsu.ccfit.kozlova.autoparts.app.services.crud.ServiceResponse;
import ru.nsu.ccfit.kozlova.autoparts.app.services.crud.pagination.Page;
import ru.nsu.ccfit.kozlova.autoparts.app.services.crud.pagination.PageInfo;

public class SupplierService extends AbstractService {

	private final SupplierServiceApi supplierServiceApi;

	public SupplierService(String baseUrl) {
		super(SupplierServiceApi.class, baseUrl);
		supplierServiceApi = (SupplierServiceApi) getServiceApi();
	}

	public ServiceResponse<Page<GuaranteeDto>> getSupplierGuarantees(Long supplierId, PageInfo pageInfo) {
		var call = supplierServiceApi.getSupplierGuarantees(supplierId, PageInfo.toMap(pageInfo));
		return getServerResponse(call);
	}

	public ServiceResponse<Page<SupplierDto>> getAll(PageInfo pageInfo) {
		var call = supplierServiceApi.getAll(PageInfo.toMap(pageInfo));
		return getServerResponse(call);
	}

}
