package ru.nsu.ccfit.kozlova.autoparts.app.gui.forms.input.sales.customers;

import ru.nsu.ccfit.kozlova.autoparts.app.gui.controllers.EntityInputFormController;
import ru.nsu.ccfit.kozlova.autoparts.app.gui.forms.input.AbstractEntityInputFormBuilder;
import ru.nsu.ccfit.kozlova.autoparts.app.model.sales.customers.CustomerCreateRequest;
import ru.nsu.ccfit.kozlova.autoparts.app.model.sales.customers.CustomerDto;
import ru.nsu.ccfit.kozlova.autoparts.app.model.sales.customers.CustomerUpdateRequest;
import ru.nsu.ccfit.kozlova.autoparts.app.model.suppliers.shops.ShopCreateRequest;
import ru.nsu.ccfit.kozlova.autoparts.app.model.suppliers.shops.ShopUpdateRequest;
import ru.nsu.ccfit.kozlova.autoparts.app.utils.RequestExecutor;
import ru.nsu.ccfit.kozlova.autoparts.app.utils.ServiceFactory;

public class CustomerInputFormBuilder
		extends AbstractEntityInputFormBuilder<CustomerDto, CustomerCreateRequest, CustomerUpdateRequest> {

	public CustomerInputFormBuilder(RequestExecutor requestExecutor) {
		super(
				"Клиент",
				ServiceFactory.getCustomerService(),
				requestExecutor,
				CustomerCreateRequest::new,
				c -> CustomerUpdateRequest.builder()
						.name(c.getName())
						.build()
		);
	}

	@Override
	public void fillCreateInputForm(
			CustomerCreateRequest createRequest,
			EntityInputFormController<CustomerCreateRequest, CustomerDto> controller,
			boolean isContextWindow
	) {

		controller.addTextField(
				"ФИО",
				createRequest.getName(),
				createRequest::setName
		);

	}

	@Override
	public void fillEditInputForm(
			CustomerUpdateRequest updateRequest,
			EntityInputFormController<CustomerUpdateRequest, CustomerDto> controller,
			boolean isContextWindow
	) {

		controller.addTextField(
				"ФИО",
				updateRequest.getName(),
				updateRequest::setName
		);

	}

}
