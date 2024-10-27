package ru.nsu.ccfit.kozlova.autoparts.app.gui.forms.input.details.storage;

import ru.nsu.ccfit.kozlova.autoparts.app.gui.controllers.EntityInputFormController;
import ru.nsu.ccfit.kozlova.autoparts.app.gui.forms.input.AbstractEntityInputFormBuilder;
import ru.nsu.ccfit.kozlova.autoparts.app.model.details.storage.StorageCellCreateRequest;
import ru.nsu.ccfit.kozlova.autoparts.app.model.details.storage.StorageCellDto;
import ru.nsu.ccfit.kozlova.autoparts.app.model.details.storage.StorageCellUpdateRequest;
import ru.nsu.ccfit.kozlova.autoparts.app.model.suppliers.shops.ShopCreateRequest;
import ru.nsu.ccfit.kozlova.autoparts.app.model.suppliers.shops.ShopUpdateRequest;
import ru.nsu.ccfit.kozlova.autoparts.app.utils.RequestExecutor;
import ru.nsu.ccfit.kozlova.autoparts.app.utils.ServiceFactory;

public class StorageCellInputFormBuilder
		extends AbstractEntityInputFormBuilder<StorageCellDto, StorageCellCreateRequest, StorageCellUpdateRequest> {

	public StorageCellInputFormBuilder(RequestExecutor requestExecutor) {
		super(
				"Ячейка склада",
				ServiceFactory.getStorageCellService(),
				requestExecutor,
				StorageCellCreateRequest::new,
				sc -> StorageCellUpdateRequest.builder().build()
		);
	}

	@Override
	public void fillCreateInputForm(
			StorageCellCreateRequest createRequest,
			EntityInputFormController<StorageCellCreateRequest, StorageCellDto> controller,
			boolean isContextWindow
	) {

	}

	@Override
	public void fillEditInputForm(
			StorageCellUpdateRequest updateRequest,
			EntityInputFormController<StorageCellUpdateRequest, StorageCellDto> controller,
			boolean isContextWindow
	) {

	}

}
