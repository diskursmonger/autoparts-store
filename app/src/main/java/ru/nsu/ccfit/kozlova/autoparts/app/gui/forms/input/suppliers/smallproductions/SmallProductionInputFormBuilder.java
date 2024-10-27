package ru.nsu.ccfit.kozlova.autoparts.app.gui.forms.input.suppliers.smallproductions;

import ru.nsu.ccfit.kozlova.autoparts.app.gui.controllers.EntityInputFormController;
import ru.nsu.ccfit.kozlova.autoparts.app.gui.forms.input.AbstractEntityInputFormBuilder;
import ru.nsu.ccfit.kozlova.autoparts.app.model.suppliers.smallproductions.SmallProductionCreateRequest;
import ru.nsu.ccfit.kozlova.autoparts.app.model.suppliers.smallproductions.SmallProductionDto;
import ru.nsu.ccfit.kozlova.autoparts.app.model.suppliers.smallproductions.SmallProductionUpdateRequest;
import ru.nsu.ccfit.kozlova.autoparts.app.utils.RequestExecutor;
import ru.nsu.ccfit.kozlova.autoparts.app.utils.ServiceFactory;

public class SmallProductionInputFormBuilder
	extends AbstractEntityInputFormBuilder<
		SmallProductionDto, SmallProductionCreateRequest, SmallProductionUpdateRequest> {

	public SmallProductionInputFormBuilder(RequestExecutor requestExecutor) {
		super(
				"Малое производство",
				ServiceFactory.getSmallProductionService(),
				requestExecutor,
				SmallProductionCreateRequest::new,
				sp -> SmallProductionUpdateRequest.builder()
						.name(sp.getName())
						.website(sp.getWebsite())
						.build()
		);
	}

	@Override
	public void fillCreateInputForm(
			SmallProductionCreateRequest createRequest,
			EntityInputFormController<SmallProductionCreateRequest, SmallProductionDto> controller,
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
			SmallProductionUpdateRequest updateRequest,
			EntityInputFormController<SmallProductionUpdateRequest, SmallProductionDto> controller,
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
