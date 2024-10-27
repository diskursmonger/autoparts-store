package ru.nsu.ccfit.kozlova.autoparts.app.gui.forms.input.suppliers.firms;

import ru.nsu.ccfit.kozlova.autoparts.app.gui.controllers.EntityInputFormController;
import ru.nsu.ccfit.kozlova.autoparts.app.gui.forms.input.AbstractEntityInputFormBuilder;
import ru.nsu.ccfit.kozlova.autoparts.app.model.suppliers.firms.FirmCreateRequest;
import ru.nsu.ccfit.kozlova.autoparts.app.model.suppliers.firms.FirmDto;
import ru.nsu.ccfit.kozlova.autoparts.app.model.suppliers.firms.FirmUpdateRequest;
import ru.nsu.ccfit.kozlova.autoparts.app.model.suppliers.shops.ShopCreateRequest;
import ru.nsu.ccfit.kozlova.autoparts.app.model.suppliers.shops.ShopUpdateRequest;
import ru.nsu.ccfit.kozlova.autoparts.app.utils.RequestExecutor;
import ru.nsu.ccfit.kozlova.autoparts.app.utils.ServiceFactory;

public class FirmInputFormBuilder
		extends AbstractEntityInputFormBuilder<FirmDto, FirmCreateRequest, FirmUpdateRequest> {

	public FirmInputFormBuilder(RequestExecutor requestExecutor) {
		super(
				"Фирма",
				ServiceFactory.getFirmService(),
				requestExecutor,
				FirmCreateRequest::new,
				f -> FirmUpdateRequest.builder()
						.name(f.getName())
						.website(f.getWebsite())
						.build()
		);
	}

	@Override
	public void fillCreateInputForm(
			FirmCreateRequest createRequest,
			EntityInputFormController<FirmCreateRequest, FirmDto> controller,
			boolean isContextWindow
	) {

		controller.addTextField(
				"Название",
				createRequest.getName(),
				createRequest::setName
		);

		controller.addTextField(
				"Веб-сайт",
				createRequest.getWebsite(),
				createRequest::setWebsite
		);

	}

	@Override
	public void fillEditInputForm(
			FirmUpdateRequest updateRequest,
			EntityInputFormController<FirmUpdateRequest, FirmDto> controller,
			boolean isContextWindow
	) {

		controller.addTextField(
				"Название",
				updateRequest.getName(),
				updateRequest::setName
		);

		controller.addTextField(
				"Веб-сайт",
				updateRequest.getWebsite(),
				updateRequest::setWebsite
		);

	}

}
