package ru.nsu.ccfit.kozlova.autoparts.app.gui.forms.input.sales;

import ru.nsu.ccfit.kozlova.autoparts.app.gui.controllers.EntityInputFormController;
import ru.nsu.ccfit.kozlova.autoparts.app.gui.controllers.interfaces.ChoiceItemSupplier;
import ru.nsu.ccfit.kozlova.autoparts.app.gui.forms.input.AbstractEntityInputFormBuilder;
import ru.nsu.ccfit.kozlova.autoparts.app.model.sales.SaleCreateRequest;
import ru.nsu.ccfit.kozlova.autoparts.app.model.sales.SaleDto;
import ru.nsu.ccfit.kozlova.autoparts.app.model.sales.SaleUpdateRequest;
import ru.nsu.ccfit.kozlova.autoparts.app.model.sales.orders.OrderDto;
import ru.nsu.ccfit.kozlova.autoparts.app.model.suppliers.shops.ShopCreateRequest;
import ru.nsu.ccfit.kozlova.autoparts.app.model.suppliers.shops.ShopUpdateRequest;
import ru.nsu.ccfit.kozlova.autoparts.app.utils.RequestExecutor;
import ru.nsu.ccfit.kozlova.autoparts.app.utils.ServiceFactory;

import java.util.Objects;
import java.util.Optional;

public class SaleInputFormBuilder
		extends AbstractEntityInputFormBuilder<SaleDto, SaleCreateRequest, SaleUpdateRequest> {

	public SaleInputFormBuilder(RequestExecutor requestExecutor) {
		super(
				"Покупка",
				ServiceFactory.getSaleService(),
				requestExecutor,
				SaleCreateRequest::new,
				s -> SaleUpdateRequest.builder()
						.saleDate(s.getSaleDate())
						.customerId(s.getCustomer().getId())
						.orderId(Optional.ofNullable(s.getOrder()).map(OrderDto::getId).orElse(null))
						.build()
		);
	}

	@Override
	public void fillCreateInputForm(
			SaleCreateRequest createRequest,
			EntityInputFormController<SaleCreateRequest, SaleDto> controller,
			boolean isContextWindow
	) {

		controller.addDateField(
				"Дата покупки",
				createRequest.getSaleDate(),
				createRequest::setSaleDate
		);

		controller.addIntegerField(
				"№ клиента",
				toInteger(createRequest.getCustomerId()),
				id -> createRequest.setCustomerId(toLong(id))
		);

		controller.addNullableIntegerField(
				"№ заказа",
				toInteger(createRequest.getOrderId()),
				id -> createRequest.setOrderId(toLong(id))
		);

	}

	@Override
	public void fillEditInputForm(
			SaleUpdateRequest updateRequest,
			EntityInputFormController<SaleUpdateRequest, SaleDto> controller,
			boolean isContextWindow
	) {

		controller.addDateField(
				"Дата покупки",
				updateRequest.getSaleDate(),
				updateRequest::setSaleDate
		);

		controller.addIntegerField(
				"№ клиента",
				toInteger(updateRequest.getCustomerId()),
				id -> updateRequest.setCustomerId(toLong(id))
		);

		controller.addNullableIntegerField(
				"№ заказа",
				toInteger(updateRequest.getOrderId()),
				id -> updateRequest.setOrderId(toLong(id))
		);

	}

}
