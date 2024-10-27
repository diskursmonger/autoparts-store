package ru.nsu.ccfit.kozlova.autoparts.app.gui.forms.input.details.types;

import ru.nsu.ccfit.kozlova.autoparts.app.gui.controllers.EntityInputFormController;
import ru.nsu.ccfit.kozlova.autoparts.app.gui.forms.input.AbstractEntityInputFormBuilder;
import ru.nsu.ccfit.kozlova.autoparts.app.model.details.types.DetailTypeCreateRequest;
import ru.nsu.ccfit.kozlova.autoparts.app.model.details.types.DetailTypeDto;
import ru.nsu.ccfit.kozlova.autoparts.app.model.details.types.DetailTypeUpdateRequest;
import ru.nsu.ccfit.kozlova.autoparts.app.model.suppliers.shops.ShopCreateRequest;
import ru.nsu.ccfit.kozlova.autoparts.app.model.suppliers.shops.ShopUpdateRequest;
import ru.nsu.ccfit.kozlova.autoparts.app.utils.RequestExecutor;
import ru.nsu.ccfit.kozlova.autoparts.app.utils.ServiceFactory;

public class DetailTypeInputFormBuilder
		extends AbstractEntityInputFormBuilder<DetailTypeDto, DetailTypeCreateRequest, DetailTypeUpdateRequest> {

	public DetailTypeInputFormBuilder(RequestExecutor requestExecutor) {
		super(
				"Тип детали",
				ServiceFactory.getDetailTypeService(),
				requestExecutor,
				DetailTypeCreateRequest::new,
				dt -> DetailTypeUpdateRequest.builder()
						.name(dt.getName())
						.shopPrice(dt.getShopPrice())
						.build()
		);
	}

	@Override
	public void fillCreateInputForm(
			DetailTypeCreateRequest createRequest,
			EntityInputFormController<DetailTypeCreateRequest, DetailTypeDto> controller,
			boolean isContextWindow
	) {

		controller.addTextField(
				"Название типа детали",
				createRequest.getName(),
				createRequest::setName
		);

		controller.addDoubleField(
				"Цена",
				createRequest.getShopPrice(),
				createRequest::setShopPrice
		);

	}

	@Override
	public void fillEditInputForm(
			DetailTypeUpdateRequest updateRequest,
			EntityInputFormController<DetailTypeUpdateRequest, DetailTypeDto> controller,
			boolean isContextWindow
	) {

		controller.addTextField(
				"Название типа детали",
				updateRequest.getName(),
				updateRequest::setName
		);

		controller.addDoubleField(
				"Цена",
				updateRequest.getShopPrice(),
				updateRequest::setShopPrice
		);

	}

}
