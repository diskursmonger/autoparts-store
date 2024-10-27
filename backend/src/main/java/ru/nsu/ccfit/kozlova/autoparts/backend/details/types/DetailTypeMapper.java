package ru.nsu.ccfit.kozlova.autoparts.backend.details.types;

import org.springframework.stereotype.Component;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.details.types.DetailTypeCreateRequest;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.details.types.DetailTypeDto;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.details.types.DetailTypeUpdateRequest;
import ru.nsu.ccfit.kozlova.autoparts.backend.crud.data.Mapper;
import static ru.nsu.ccfit.kozlova.autoparts.backend.crud.data.MapperUtils.setIfNotNull;

@Component
public class DetailTypeMapper implements Mapper<
		DetailType, DetailTypeDto, DetailTypeCreateRequest, DetailTypeUpdateRequest> {

	@Override
	public DetailType createEntity(DetailTypeCreateRequest createRequest) {
		ShopDetailTypePrice shopDetailTypePrice = ShopDetailTypePrice.builder()
				.shopPrice(createRequest.getShopPrice())
				.build();

		DetailType detailType = DetailType.builder()
				.name(createRequest.getName())
				.shopDetailTypePrice(shopDetailTypePrice)
				.build();

		shopDetailTypePrice.setDetailType(detailType);

		return detailType;
	}

	@Override
	public void updateEntity(DetailType detailType, DetailTypeUpdateRequest updateRequest) {
		setIfNotNull(updateRequest.getName(), detailType::setName);
		setIfNotNull(updateRequest.getShopPrice(), shopPrice -> {
			detailType.getShopDetailTypePrice().setShopPrice(shopPrice);
		});
	}

	@Override
	public DetailTypeDto toDto(DetailType detailType) {
		return DetailTypeDto.builder()
				.id(detailType.getId())
				.name(detailType.getName())
				.shopPrice(detailType.getShopDetailTypePrice().getShopPrice())
				.build();
	}
}
