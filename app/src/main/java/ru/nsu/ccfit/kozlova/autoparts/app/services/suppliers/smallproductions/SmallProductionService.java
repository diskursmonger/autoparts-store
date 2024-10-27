package ru.nsu.ccfit.kozlova.autoparts.app.services.suppliers.smallproductions;

import ru.nsu.ccfit.kozlova.autoparts.app.model.suppliers.smallproductions.SmallProductionCreateRequest;
import ru.nsu.ccfit.kozlova.autoparts.app.model.suppliers.smallproductions.SmallProductionDto;
import ru.nsu.ccfit.kozlova.autoparts.app.model.suppliers.smallproductions.SmallProductionUpdateRequest;
import ru.nsu.ccfit.kozlova.autoparts.app.services.crud.AbstractCrudService;
import ru.nsu.ccfit.kozlova.autoparts.app.services.crud.CrudServiceApi;

public class SmallProductionService
		extends AbstractCrudService<SmallProductionDto, SmallProductionCreateRequest, SmallProductionUpdateRequest> {

	public SmallProductionService(String baseUrl) {
		super(SmallProductionServiceApi.class, SmallProductionDto.class, baseUrl, "small-productions");
	}

}
