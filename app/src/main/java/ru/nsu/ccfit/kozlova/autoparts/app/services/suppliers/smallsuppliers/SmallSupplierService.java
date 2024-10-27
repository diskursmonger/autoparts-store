package ru.nsu.ccfit.kozlova.autoparts.app.services.suppliers.smallsuppliers;

import ru.nsu.ccfit.kozlova.autoparts.app.model.suppliers.SupplierDto;
import ru.nsu.ccfit.kozlova.autoparts.app.model.suppliers.smallsuppliers.SmallSupplierCreateRequest;
import ru.nsu.ccfit.kozlova.autoparts.app.model.suppliers.smallsuppliers.SmallSupplierDto;
import ru.nsu.ccfit.kozlova.autoparts.app.model.suppliers.smallsuppliers.SmallSupplierUpdateRequest;
import ru.nsu.ccfit.kozlova.autoparts.app.services.crud.AbstractCrudService;
import ru.nsu.ccfit.kozlova.autoparts.app.services.suppliers.SupplierServiceApi;

public class SmallSupplierService
		extends AbstractCrudService<SmallSupplierDto, SmallSupplierCreateRequest, SmallSupplierUpdateRequest> {

	public SmallSupplierService(String baseUrl) {
		super(SmallSupplierServiceApi.class, SmallSupplierDto.class, baseUrl, "small-suppliers");
	}

}
