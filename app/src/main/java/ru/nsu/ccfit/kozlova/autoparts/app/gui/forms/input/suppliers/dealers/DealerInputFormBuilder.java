package ru.nsu.ccfit.kozlova.autoparts.app.gui.forms.input.suppliers.dealers;

import ru.nsu.ccfit.kozlova.autoparts.app.gui.controllers.EntityInputFormController;
import ru.nsu.ccfit.kozlova.autoparts.app.gui.forms.input.AbstractEntityInputFormBuilder;
import ru.nsu.ccfit.kozlova.autoparts.app.model.suppliers.dealers.DealerCreateRequest;
import ru.nsu.ccfit.kozlova.autoparts.app.model.suppliers.dealers.DealerDto;
import ru.nsu.ccfit.kozlova.autoparts.app.model.suppliers.dealers.DealerUpdateRequest;
import ru.nsu.ccfit.kozlova.autoparts.app.model.suppliers.shops.ShopCreateRequest;
import ru.nsu.ccfit.kozlova.autoparts.app.model.suppliers.shops.ShopUpdateRequest;
import ru.nsu.ccfit.kozlova.autoparts.app.utils.RequestExecutor;
import ru.nsu.ccfit.kozlova.autoparts.app.utils.ServiceFactory;

public class DealerInputFormBuilder
		extends AbstractEntityInputFormBuilder<DealerDto, DealerCreateRequest, DealerUpdateRequest> {

	public DealerInputFormBuilder(RequestExecutor requestExecutor) {
		super(
				"Дилер",
				ServiceFactory.getDealerService(),
				requestExecutor,
				DealerCreateRequest::new,
				d -> DealerUpdateRequest.builder()
						.name(d.getName())
						.website(d.getWebsite())
						.build()
		);
	}

	@Override
	public void fillCreateInputForm(
			DealerCreateRequest createRequest,
			EntityInputFormController<DealerCreateRequest, DealerDto> controller,
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
			DealerUpdateRequest updateRequest,
			EntityInputFormController<DealerUpdateRequest, DealerDto> controller,
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
