package ru.nsu.ccfit.kozlova.autoparts.backend.details.storage;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.details.storage.StorageCellCreateRequest;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.details.storage.StorageCellDto;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.details.storage.StorageCellUpdateRequest;
import ru.nsu.ccfit.kozlova.autoparts.backend.crud.controller.AbstractCrudController;

@RestController
@RequestMapping("/storage-cells")
public class StorageCellController extends AbstractCrudController<
		StorageCellDto, StorageCellCreateRequest, StorageCellUpdateRequest, Long> {

	private final StorageCellService storageCellService;

	public StorageCellController(StorageCellService storageCellService) {
		super(storageCellService);
		this.storageCellService = storageCellService;
	}
}
