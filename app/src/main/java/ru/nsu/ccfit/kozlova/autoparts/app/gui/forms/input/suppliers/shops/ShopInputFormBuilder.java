package ru.nsu.ccfit.kozlova.autoparts.app.gui.forms.input.suppliers.shops;

import ru.nsu.ccfit.kozlova.autoparts.app.gui.controllers.EntityInputFormController;
import ru.nsu.ccfit.kozlova.autoparts.app.gui.forms.input.AbstractEntityInputFormBuilder;
import ru.nsu.ccfit.kozlova.autoparts.app.model.suppliers.shops.ShopCreateRequest;
import ru.nsu.ccfit.kozlova.autoparts.app.model.suppliers.shops.ShopDto;
import ru.nsu.ccfit.kozlova.autoparts.app.model.suppliers.shops.ShopUpdateRequest;
import ru.nsu.ccfit.kozlova.autoparts.app.model.suppliers.smallproductions.SmallProductionCreateRequest;
import ru.nsu.ccfit.kozlova.autoparts.app.model.suppliers.smallproductions.SmallProductionUpdateRequest;
import ru.nsu.ccfit.kozlova.autoparts.app.utils.RequestExecutor;
import ru.nsu.ccfit.kozlova.autoparts.app.utils.ServiceFactory;

public class ShopInputFormBuilder
		extends AbstractEntityInputFormBuilder<ShopDto, ShopCreateRequest, ShopUpdateRequest> {

	public ShopInputFormBuilder(RequestExecutor requestExecutor) {
		super(
				"Магазин",
				ServiceFactory.getShopService(),
				requestExecutor,
				ShopCreateRequest::new,
				s -> ShopUpdateRequest.builder()
						.name(s.getName())
						.address(s.getAddress())
						.build()
		);
	}

	@Override
	public void fillCreateInputForm(
			ShopCreateRequest createRequest,
			EntityInputFormController<ShopCreateRequest, ShopDto> controller,
			boolean isContextWindow
	) {

		controller.addTextField(
				"Название",
				createRequest.getName(),
				createRequest::setName
		);

		controller.addTextField(
				"Адрес",
				createRequest.getAddress(),
				createRequest::setAddress
		);

	}

	@Override
	public void fillEditInputForm(
			ShopUpdateRequest updateRequest,
			EntityInputFormController<ShopUpdateRequest, ShopDto> controller,
			boolean isContextWindow
	) {

		controller.addTextField(
				"Название",
				updateRequest.getName(),
				updateRequest::setName
		);

		controller.addTextField(
				"Адрес",
				updateRequest.getAddress(),
				updateRequest::setAddress
		);

	}

}
