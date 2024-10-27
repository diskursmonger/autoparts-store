package ru.nsu.ccfit.kozlova.autoparts.app.services.suppliers.firms;

import ru.nsu.ccfit.kozlova.autoparts.app.model.suppliers.firms.FirmCreateRequest;
import ru.nsu.ccfit.kozlova.autoparts.app.model.suppliers.firms.FirmDto;
import ru.nsu.ccfit.kozlova.autoparts.app.model.suppliers.firms.FirmUpdateRequest;
import ru.nsu.ccfit.kozlova.autoparts.app.services.crud.AbstractCrudService;

public class FirmService extends AbstractCrudService<FirmDto, FirmCreateRequest, FirmUpdateRequest> {

	public FirmService(String baseUrl) {
		super(FirmServiceApi.class, FirmDto.class, baseUrl, "firms");
	}

}
