package ru.nsu.ccfit.kozlova.autoparts.app.gui.forms.input.sales.orders;

import ru.nsu.ccfit.kozlova.autoparts.app.gui.controllers.EntityInputFormController;
import ru.nsu.ccfit.kozlova.autoparts.app.gui.forms.input.AbstractEntityInputFormBuilder;
import ru.nsu.ccfit.kozlova.autoparts.app.model.sales.orders.OrderCreateRequest;
import ru.nsu.ccfit.kozlova.autoparts.app.model.sales.orders.OrderDto;
import ru.nsu.ccfit.kozlova.autoparts.app.model.sales.orders.OrderUpdateRequest;
import ru.nsu.ccfit.kozlova.autoparts.app.model.suppliers.shops.ShopCreateRequest;
import ru.nsu.ccfit.kozlova.autoparts.app.model.suppliers.shops.ShopUpdateRequest;
import ru.nsu.ccfit.kozlova.autoparts.app.utils.RequestExecutor;
import ru.nsu.ccfit.kozlova.autoparts.app.utils.ServiceFactory;

public class OrderInputFormBuilder
		extends AbstractEntityInputFormBuilder<OrderDto, OrderCreateRequest, OrderUpdateRequest> {

	public OrderInputFormBuilder(RequestExecutor requestExecutor) {
		super(
				"Заказ",
				ServiceFactory.getOrderService(),
				requestExecutor,
				OrderCreateRequest::new,
				o -> OrderUpdateRequest.builder()
						.orderDate(o.getOrderDate())
						.customerId(o.getCustomer().getId())
						.build()
		);
	}

	@Override
	public void fillCreateInputForm(
			OrderCreateRequest createRequest,
			EntityInputFormController<OrderCreateRequest, OrderDto> controller,
			boolean isContextWindow
	) {

		controller.addDateField(
				"Дата заказа",
				createRequest.getOrderDate(),
				createRequest::setOrderDate
		);

		controller.addIntegerField(
				"№ клиента",
				toInteger(createRequest.getCustomerId()),
				id -> createRequest.setCustomerId(toLong(id))
		);

	}

	@Override
	public void fillEditInputForm(
			OrderUpdateRequest updateRequest,
			EntityInputFormController<OrderUpdateRequest, OrderDto> controller,
			boolean isContextWindow
	) {

		controller.addDateField(
				"Дата заказа",
				updateRequest.getOrderDate(),
				updateRequest::setOrderDate
		);

		controller.addIntegerField(
				"№ клиента",
				toInteger(updateRequest.getCustomerId()),
				id -> updateRequest.setCustomerId(toLong(id))
		);

	}

}
