package ru.nsu.ccfit.kozlova.autoparts.backend.details.storage;

import org.springframework.stereotype.Service;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.details.storage.StorageCellCreateRequest;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.details.storage.StorageCellDto;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.details.storage.StorageCellUpdateRequest;
import ru.nsu.ccfit.kozlova.autoparts.backend.crud.service.AbstractCrudService;

@Service
public class StorageCellService extends AbstractCrudService<
		StorageCell, StorageCellDto, StorageCellCreateRequest, StorageCellUpdateRequest, Long> {

	private final StorageCellRepository storageCellRepository;
	private final StorageCellMapper storageCellMapper;

	public StorageCellService(
			StorageCellRepository storageCellRepository,
			StorageCellMapper storageCellMapper
	) {
		super(storageCellRepository, storageCellMapper);
		this.storageCellRepository = storageCellRepository;
		this.storageCellMapper = storageCellMapper;
	}
}
