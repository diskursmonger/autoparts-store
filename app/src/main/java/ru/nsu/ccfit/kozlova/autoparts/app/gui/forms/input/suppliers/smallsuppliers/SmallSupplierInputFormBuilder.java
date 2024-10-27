package ru.nsu.ccfit.kozlova.autoparts.app.gui.forms.input.suppliers.smallsuppliers;

import ru.nsu.ccfit.kozlova.autoparts.app.gui.controllers.EntityInputFormController;
import ru.nsu.ccfit.kozlova.autoparts.app.gui.forms.input.AbstractEntityInputFormBuilder;
import ru.nsu.ccfit.kozlova.autoparts.app.model.suppliers.smallsuppliers.SmallSupplierCreateRequest;
import ru.nsu.ccfit.kozlova.autoparts.app.model.suppliers.smallsuppliers.SmallSupplierDto;
import ru.nsu.ccfit.kozlova.autoparts.app.model.suppliers.smallsuppliers.SmallSupplierUpdateRequest;
import ru.nsu.ccfit.kozlova.autoparts.app.services.crud.CrudService;
import ru.nsu.ccfit.kozlova.autoparts.app.utils.RequestExecutor;
import ru.nsu.ccfit.kozlova.autoparts.app.utils.ServiceFactory;

import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;

public class SmallSupplierInputFormBuilder
		extends AbstractEntityInputFormBuilder<
			SmallSupplierDto, SmallSupplierCreateRequest, SmallSupplierUpdateRequest> {

	public SmallSupplierInputFormBuilder(RequestExecutor requestExecutor) {
		super(
				"Мелкий поставщик",
				ServiceFactory.getSmallSupplierService(),
				requestExecutor,
				SmallSupplierCreateRequest::new,
				ss -> SmallSupplierUpdateRequest.builder()
						.name(ss.getName())
						.phoneNumber(ss.getPhoneNumber())
						.build()
		);
	}

	@Override
	public void fillCreateInputForm(
			SmallSupplierCreateRequest createRequest,
			EntityInputFormController<SmallSupplierCreateRequest, SmallSupplierDto> controller,
			boolean isContextWindow
	) {

		controller.addTextField(
				"Название",
				createRequest.getName(),
				createRequest::setName
		);

		controller.addTextField(
				"Номер телефона",
				createRequest.getPhoneNumber(),
				createRequest::setPhoneNumber
		);

	}

	@Override
	public void fillEditInputForm(
			SmallSupplierUpdateRequest updateRequest,
			EntityInputFormController<SmallSupplierUpdateRequest, SmallSupplierDto> controller,
			boolean isContextWindow) {

		controller.addTextField(
				"Название",
				updateRequest.getName(),
				updateRequest::setName
		);

		controller.addTextField(
				"Номер телефона",
				updateRequest.getPhoneNumber(),
				updateRequest::setPhoneNumber
		);

	}

}
