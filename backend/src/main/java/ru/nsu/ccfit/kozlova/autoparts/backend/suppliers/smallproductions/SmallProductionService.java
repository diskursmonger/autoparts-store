package ru.nsu.ccfit.kozlova.autoparts.backend.suppliers.smallproductions;

import org.springframework.stereotype.Service;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.suppliers.smallproductions.SmallProductionCreateRequest;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.suppliers.smallproductions.SmallProductionDto;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.suppliers.smallproductions.SmallProductionUpdateRequest;
import ru.nsu.ccfit.kozlova.autoparts.backend.crud.service.AbstractCrudService;

@Service
public class SmallProductionService extends AbstractCrudService<
		SmallProduction, SmallProductionDto, SmallProductionCreateRequest, SmallProductionUpdateRequest, Long> {

	private final SmallProductionRepository smallProductionRepository;
	private final SmallProductionMapper smallProductionMapper;

	public SmallProductionService(
			SmallProductionRepository smallProductionRepository,
			SmallProductionMapper smallProductionMapper
	) {
		super(smallProductionRepository, smallProductionMapper);
		this.smallProductionRepository = smallProductionRepository;
		this.smallProductionMapper = smallProductionMapper;
	}
}
