package ru.nsu.ccfit.kozlova.autoparts.app.gui.forms.input.deliveries;

import ru.nsu.ccfit.kozlova.autoparts.app.gui.controllers.EntityInputFormController;
import ru.nsu.ccfit.kozlova.autoparts.app.gui.controllers.interfaces.ChoiceItemSupplier;
import ru.nsu.ccfit.kozlova.autoparts.app.gui.custom.ChoiceItem;
import ru.nsu.ccfit.kozlova.autoparts.app.gui.forms.input.AbstractEntityInputFormBuilder;
import ru.nsu.ccfit.kozlova.autoparts.app.model.deliveries.DeliveryCreateRequest;
import ru.nsu.ccfit.kozlova.autoparts.app.model.deliveries.DeliveryDto;
import ru.nsu.ccfit.kozlova.autoparts.app.model.deliveries.DeliveryUpdateRequest;
import ru.nsu.ccfit.kozlova.autoparts.app.model.suppliers.shops.ShopCreateRequest;
import ru.nsu.ccfit.kozlova.autoparts.app.model.suppliers.shops.ShopUpdateRequest;
import ru.nsu.ccfit.kozlova.autoparts.app.utils.RequestExecutor;
import ru.nsu.ccfit.kozlova.autoparts.app.utils.ServiceFactory;

public class DeliveryInputFormBuilder
		extends AbstractEntityInputFormBuilder<DeliveryDto, DeliveryCreateRequest, DeliveryUpdateRequest> {

	public DeliveryInputFormBuilder(RequestExecutor requestExecutor) {
		super(
				"Поставка",
				ServiceFactory.getDeliveryService(),
				requestExecutor,
				DeliveryCreateRequest::new,
				d -> DeliveryUpdateRequest.builder()
						.discountPercent(d.getDiscountPercent())
						.formationDate(d.getFormationDate())
						.deliveryDate(d.getDeliveryDate())
						.supplierId(d.getSupplier().getId())
						.build()
		);
	}

	@Override
	public void fillCreateInputForm(
			DeliveryCreateRequest createRequest,
			EntityInputFormController<DeliveryCreateRequest, DeliveryDto> controller,
			boolean isContextWindow
	) {

		controller.addChoiceBox(
				"Поставщик",
				createRequest.getSupplierId(),
				createRequest::setSupplierId,
				getSupplierIdSupplier()
		);

		controller.addDateField(
				"Дата оформления",
				createRequest.getFormationDate(),
				createRequest::setFormationDate
		);

		controller.addNullableDateField(
				"Дата доставки",
				createRequest.getDeliveryDate(),
				createRequest::setDeliveryDate
		);

		controller.addDoubleField(
				"Скидка, %",
				createRequest.getDiscountPercent(),
				createRequest::setDiscountPercent
		);

	}

	@Override
	public void fillEditInputForm(
			DeliveryUpdateRequest updateRequest,
			EntityInputFormController<DeliveryUpdateRequest, DeliveryDto> controller,
			boolean isContextWindow
	) {

		controller.addChoiceBox(
				"Поставщик",
				updateRequest.getSupplierId(),
				updateRequest::setSupplierId,
				getSupplierIdSupplier()
		);

		controller.addDateField(
				"Дата оформления",
				updateRequest.getFormationDate(),
				updateRequest::setFormationDate
		);

		controller.addNullableDateField(
				"Дата доставки",
				updateRequest.getDeliveryDate(),
				updateRequest::setDeliveryDate
		);

		controller.addDoubleField(
				"Скидка, %",
				updateRequest.getDiscountPercent(),
				updateRequest::setDiscountPercent
		);

	}

	private ChoiceItemSupplier<Long> getSupplierIdSupplier() {
		return makeChoiceItemSupplierFromEntities(
				ServiceFactory.getSupplierService()::getAll,
				s -> new ChoiceItem<>(s.getId(), s.getName()),
				"Не удалось загрузить список поставщиков"
		);
	}

}
