package ru.nsu.ccfit.kozlova.autoparts.app.services.suppliers.dealers;

import ru.nsu.ccfit.kozlova.autoparts.app.model.suppliers.dealers.DealerCreateRequest;
import ru.nsu.ccfit.kozlova.autoparts.app.model.suppliers.dealers.DealerDto;
import ru.nsu.ccfit.kozlova.autoparts.app.model.suppliers.dealers.DealerUpdateRequest;
import ru.nsu.ccfit.kozlova.autoparts.app.services.crud.AbstractCrudService;

public class DealerService extends AbstractCrudService<DealerDto, DealerCreateRequest, DealerUpdateRequest> {

	public DealerService(String baseUrl) {
		super(DealerServiceApi.class, DealerDto.class, baseUrl, "dealers");
	}

}
