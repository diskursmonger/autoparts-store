package ru.nsu.ccfit.kozlova.autoparts.app.services.details.storage;

import ru.nsu.ccfit.kozlova.autoparts.app.model.details.storage.StorageCellCreateRequest;
import ru.nsu.ccfit.kozlova.autoparts.app.model.details.storage.StorageCellDto;
import ru.nsu.ccfit.kozlova.autoparts.app.model.details.storage.StorageCellUpdateRequest;
import ru.nsu.ccfit.kozlova.autoparts.app.services.crud.AbstractCrudService;

public class StorageCellService
		extends AbstractCrudService<StorageCellDto, StorageCellCreateRequest, StorageCellUpdateRequest> {

	public StorageCellService(String baseUrl) {
		super(StorageCellServiceApi.class, StorageCellDto.class, baseUrl, "storage-cells");
	}

}
