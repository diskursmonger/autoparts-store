package ru.nsu.ccfit.kozlova.autoparts.backend.suppliers.shops;

import org.springframework.stereotype.Service;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.suppliers.shops.ShopCreateRequest;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.suppliers.shops.ShopDto;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.suppliers.shops.ShopUpdateRequest;
import ru.nsu.ccfit.kozlova.autoparts.backend.crud.service.AbstractCrudService;

@Service
public class ShopService extends AbstractCrudService<
		Shop, ShopDto, ShopCreateRequest, ShopUpdateRequest, Long> {

	private final ShopRepository shopRepository;
	private final ShopMapper shopMapper;

	public ShopService(
			ShopRepository shopRepository,
			ShopMapper shopMapper
	) {
		super(shopRepository, shopMapper);
		this.shopRepository = shopRepository;
		this.shopMapper = shopMapper;
	}
}
