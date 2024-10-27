package ru.nsu.ccfit.kozlova.autoparts.backend.details.types;

import org.springframework.stereotype.Service;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.details.types.DetailTypeCreateRequest;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.details.types.DetailTypeDto;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.details.types.DetailTypeUpdateRequest;
import ru.nsu.ccfit.kozlova.autoparts.backend.crud.service.AbstractCrudService;

@Service
public class DetailTypeService extends AbstractCrudService<
		DetailType, DetailTypeDto, DetailTypeCreateRequest, DetailTypeUpdateRequest, Long> {

	private final DetailTypeRepository detailTypeRepository;
	private final DetailTypeMapper detailTypeMapper;


	public DetailTypeService(
			DetailTypeRepository detailTypeRepository,
			DetailTypeMapper detailTypeMapper
	) {
		super(detailTypeRepository, detailTypeMapper);
		this.detailTypeRepository = detailTypeRepository;
		this.detailTypeMapper = detailTypeMapper;
	}
}
