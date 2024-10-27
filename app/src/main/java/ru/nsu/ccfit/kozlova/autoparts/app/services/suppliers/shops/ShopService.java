package ru.nsu.ccfit.kozlova.autoparts.app.services.suppliers.shops;

import ru.nsu.ccfit.kozlova.autoparts.app.model.suppliers.shops.ShopCreateRequest;
import ru.nsu.ccfit.kozlova.autoparts.app.model.suppliers.shops.ShopDto;
import ru.nsu.ccfit.kozlova.autoparts.app.model.suppliers.shops.ShopUpdateRequest;
import ru.nsu.ccfit.kozlova.autoparts.app.services.crud.AbstractCrudService;

public class ShopService
		extends AbstractCrudService<ShopDto, ShopCreateRequest, ShopUpdateRequest> {

	public ShopService(String baseUrl) {
		super(ShopServiceApi.class, ShopDto.class, baseUrl, "shops");
	}

}
