package ru.nsu.ccfit.kozlova.autoparts.backend.suppliers.shops;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.suppliers.shops.ShopCreateRequest;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.suppliers.shops.ShopDto;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.suppliers.shops.ShopUpdateRequest;
import ru.nsu.ccfit.kozlova.autoparts.backend.crud.controller.AbstractCrudController;

@RestController
@RequestMapping("/shops")
public class ShopController extends AbstractCrudController<
		ShopDto, ShopCreateRequest, ShopUpdateRequest, Long> {

	private final ShopService shopService;

	public ShopController(ShopService shopService) {
		super(shopService);
		this.shopService = shopService;
	}
}
