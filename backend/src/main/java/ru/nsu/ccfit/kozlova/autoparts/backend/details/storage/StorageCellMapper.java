package ru.nsu.ccfit.kozlova.autoparts.backend.details.storage;

import org.springframework.stereotype.Component;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.details.DetailDto;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.details.storage.StorageCellCreateRequest;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.details.storage.StorageCellDto;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.details.storage.StorageCellUpdateRequest;
import ru.nsu.ccfit.kozlova.autoparts.backend.crud.data.Mapper;
import ru.nsu.ccfit.kozlova.autoparts.backend.details.DetailMapper;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class StorageCellMapper implements Mapper<
		StorageCell, StorageCellDto, StorageCellCreateRequest, StorageCellUpdateRequest> {

	private final DetailMapper detailMapper;

	public StorageCellMapper(DetailMapper detailMapper) {
		this.detailMapper = detailMapper;
	}

	@Override
	public StorageCell createEntity(StorageCellCreateRequest createRequest) {
		return new StorageCell();
	}

	@Override
	public void updateEntity(StorageCell storageCell, StorageCellUpdateRequest updateRequest) {

	}

	@Override
	public StorageCellDto toDto(StorageCell storageCell) {
		Set<DetailDto> details = storageCell.getDetails()
				.stream()
				.map(detailMapper::toDto)
				.collect(Collectors.toSet());

		return StorageCellDto.builder()
				.id(storageCell.getId())
				.details(details)
				.build();
	}
}
