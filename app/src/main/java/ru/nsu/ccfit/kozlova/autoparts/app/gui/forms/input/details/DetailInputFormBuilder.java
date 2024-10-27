package ru.nsu.ccfit.kozlova.autoparts.app.gui.forms.input.details;

import ru.nsu.ccfit.kozlova.autoparts.app.gui.controllers.EntityInputFormController;
import ru.nsu.ccfit.kozlova.autoparts.app.gui.controllers.interfaces.ChoiceItemSupplier;
import ru.nsu.ccfit.kozlova.autoparts.app.gui.custom.ChoiceItem;
import ru.nsu.ccfit.kozlova.autoparts.app.gui.forms.input.AbstractEntityInputFormBuilder;
import ru.nsu.ccfit.kozlova.autoparts.app.model.details.DetailCreateRequest;
import ru.nsu.ccfit.kozlova.autoparts.app.model.details.DetailDto;
import ru.nsu.ccfit.kozlova.autoparts.app.model.details.DetailUpdateRequest;
import ru.nsu.ccfit.kozlova.autoparts.app.model.suppliers.shops.ShopCreateRequest;
import ru.nsu.ccfit.kozlova.autoparts.app.model.suppliers.shops.ShopUpdateRequest;
import ru.nsu.ccfit.kozlova.autoparts.app.utils.RequestExecutor;
import ru.nsu.ccfit.kozlova.autoparts.app.utils.ServiceFactory;

public class DetailInputFormBuilder
		extends AbstractEntityInputFormBuilder<DetailDto, DetailCreateRequest, DetailUpdateRequest> {

	public DetailInputFormBuilder(RequestExecutor requestExecutor) {
		super(
				"Деталь",
				ServiceFactory.getDetailService(),
				requestExecutor,
				DetailCreateRequest::new,
				d -> DetailUpdateRequest.builder()
						.storageCellId(d.getStorageCellId())
						.detailTypeId(d.getDetailType().getId())
						.deliveryId(d.getDeliveryId())
						.build()
		);
	}

	@Override
	public void fillCreateInputForm(
			DetailCreateRequest createRequest,
			EntityInputFormController<DetailCreateRequest, DetailDto> controller,
			boolean isContextWindow
	) {

		controller.addIntegerField(
				"№ поставки",
				toInteger(createRequest.getDeliveryId()),
				id -> createRequest.setDeliveryId(toLong(id))
		);

		controller.addChoiceBox(
				"Тип детали",
				createRequest.getDetailTypeId(),
				createRequest::setDetailTypeId,
				getDetailTypeIdSupplier()
		);

		controller.addNullableIntegerField(
				"№ ячейки склада",
				toInteger(createRequest.getStorageCellId()),
				id -> createRequest.setStorageCellId(toLong(id))
		);

	}

	@Override
	public void fillEditInputForm(
			DetailUpdateRequest updateRequest,
			EntityInputFormController<DetailUpdateRequest, DetailDto> controller,
			boolean isContextWindow
	) {

		controller.addIntegerField(
				"№ поставки",
				toInteger(updateRequest.getDeliveryId()),
				id -> updateRequest.setDeliveryId(toLong(id))
		);

		controller.addChoiceBox(
				"Тип детали",
				updateRequest.getDetailTypeId(),
				updateRequest::setDetailTypeId,
				getDetailTypeIdSupplier()
		);

		controller.addNullableIntegerField(
				"№ ячейки склада",
				toInteger(updateRequest.getStorageCellId()),
				id -> updateRequest.setStorageCellId(toLong(id))
		);

	}

	private ChoiceItemSupplier<Long> getDetailTypeIdSupplier() {
		return makeChoiceItemSupplierFromEntities(
				ServiceFactory.getDetailTypeService(),
				dt -> new ChoiceItem<>(dt.getId(), dt.getName()),
				"Не удалось загрузить список типов деталей"
		);
	}

}
