package ru.nsu.ccfit.kozlova.autoparts.app.gui.forms.input.suppliers.guarantees;

import ru.nsu.ccfit.kozlova.autoparts.app.gui.controllers.EntityInputFormController;
import ru.nsu.ccfit.kozlova.autoparts.app.gui.controllers.interfaces.ChoiceItemSupplier;
import ru.nsu.ccfit.kozlova.autoparts.app.gui.custom.ChoiceItem;
import ru.nsu.ccfit.kozlova.autoparts.app.gui.forms.input.AbstractEntityInputFormBuilder;
import ru.nsu.ccfit.kozlova.autoparts.app.model.suppliers.guarantees.GuaranteeCreateRequest;
import ru.nsu.ccfit.kozlova.autoparts.app.model.suppliers.guarantees.GuaranteeDto;
import ru.nsu.ccfit.kozlova.autoparts.app.model.suppliers.guarantees.GuaranteeUpdateRequest;
import ru.nsu.ccfit.kozlova.autoparts.app.utils.RequestExecutor;
import ru.nsu.ccfit.kozlova.autoparts.app.utils.ServiceFactory;

public class GuaranteeInputFormBuilder
		extends AbstractEntityInputFormBuilder<GuaranteeDto, GuaranteeCreateRequest, GuaranteeUpdateRequest> {

	public GuaranteeInputFormBuilder(RequestExecutor requestExecutor) {
		super(
				"Гарантия",
				ServiceFactory.getGuaranteeService(),
				requestExecutor,
				GuaranteeCreateRequest::new,
				g -> GuaranteeUpdateRequest.builder()
						.detailTypeId(g.getDetailType().getId())
						.guaranteeMonths(g.getGuaranteeMonths())
						.build()
		);
	}

	@Override
	public void fillCreateInputForm(
			GuaranteeCreateRequest createRequest,
			EntityInputFormController<GuaranteeCreateRequest, GuaranteeDto> controller,
			boolean isContextWindow
	) {

		controller.addChoiceBox(
				"Поставщик",
				createRequest.getSupplierId(),
				createRequest::setSupplierId,
				getSupplierIdSupplier()
		);

		controller.addChoiceBox(
				"Тип детали",
				createRequest.getDetailTypeId(),
				createRequest::setDetailTypeId,
				getDetailTypeIdSupplier()
		);

		controller.addIntegerField(
				"Гарантия, мес.",
				createRequest.getGuaranteeMonths(),
				createRequest::setGuaranteeMonths
		);

	}

	@Override
	public void fillEditInputForm(
			GuaranteeUpdateRequest updateRequest,
			EntityInputFormController<GuaranteeUpdateRequest, GuaranteeDto> controller,
			boolean isContextWindow
	) {

		controller.addChoiceBox(
				"Тип детали",
				updateRequest.getDetailTypeId(),
				updateRequest::setDetailTypeId,
				getDetailTypeIdSupplier()
		);

		controller.addIntegerField(
				"Гарантия, мес.",
				updateRequest.getGuaranteeMonths(),
				updateRequest::setGuaranteeMonths
		);

	}

	private ChoiceItemSupplier<Long> getSupplierIdSupplier() {
		ChoiceItemSupplier<Long> dealerIdSupplier = makeChoiceItemSupplierFromEntities(
				ServiceFactory.getDealerService(),
				d -> new ChoiceItem<>(d.getId(), d.getName()),
				"Не удалось загрузить список поставщиков"
		);

		ChoiceItemSupplier<Long> firmIdSupplier = makeChoiceItemSupplierFromEntities(
				ServiceFactory.getFirmService(),
				d -> new ChoiceItem<>(d.getId(), d.getName()),
				"Не удалось загрузить список поставщиков"
		);

		return dealerIdSupplier.mergeWith(firmIdSupplier);
	}

	private ChoiceItemSupplier<Long> getDetailTypeIdSupplier() {
		return makeChoiceItemSupplierFromEntities(
				ServiceFactory.getDetailTypeService(),
				dt -> new ChoiceItem<>(dt.getId(), dt.getName()),
				"Не удалось загрузить список типов деталей"
		);
	}

}
