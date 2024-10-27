package ru.nsu.ccfit.kozlova.autoparts.backend.suppliers.shops;

import org.springframework.stereotype.Component;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.suppliers.shops.ShopCreateRequest;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.suppliers.shops.ShopDto;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.suppliers.shops.ShopUpdateRequest;
import ru.nsu.ccfit.kozlova.autoparts.backend.crud.data.Mapper;

import static ru.nsu.ccfit.kozlova.autoparts.backend.crud.data.MapperUtils.setIfNotNull;

import java.util.Collections;

@Component
public class ShopMapper implements Mapper<Shop, ShopDto, ShopCreateRequest, ShopUpdateRequest> {
	@Override
	public Shop createEntity(ShopCreateRequest createRequest) {
		return Shop.builder()
				.name(createRequest.getName())
				.address(createRequest.getAddress())
				.build();
	}

	@Override
	public void updateEntity(Shop shop, ShopUpdateRequest updateRequest) {
		setIfNotNull(updateRequest.getName(), shop::setName);
		setIfNotNull(updateRequest.getAddress(), shop::setAddress);
	}

	@Override
	public ShopDto toDto(Shop shop) {
		return ShopDto.builder()
				.id(shop.getId())
				.name(shop.getName())
				.guarantees(Collections.emptySet())
				.address(shop.getAddress())
				.build();
	}
}
