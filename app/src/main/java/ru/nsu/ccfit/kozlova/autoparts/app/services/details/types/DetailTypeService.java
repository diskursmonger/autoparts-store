package ru.nsu.ccfit.kozlova.autoparts.app.services.details.types;

import ru.nsu.ccfit.kozlova.autoparts.app.model.details.types.DetailTypeCreateRequest;
import ru.nsu.ccfit.kozlova.autoparts.app.model.details.types.DetailTypeDto;
import ru.nsu.ccfit.kozlova.autoparts.app.model.details.types.DetailTypeUpdateRequest;
import ru.nsu.ccfit.kozlova.autoparts.app.services.crud.AbstractCrudService;

public class DetailTypeService
		extends AbstractCrudService<DetailTypeDto, DetailTypeCreateRequest, DetailTypeUpdateRequest> {

	public DetailTypeService(String baseUrl) {
		super(DetailTypeServiceApi.class, DetailTypeDto.class, baseUrl, "detail-types");
	}

}
