package ru.nsu.ccfit.kozlova.autoparts.backend.suppliers.firms;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.suppliers.firms.FirmCreateRequest;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.suppliers.firms.FirmDto;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.suppliers.firms.FirmUpdateRequest;
import ru.nsu.ccfit.kozlova.autoparts.backend.crud.controller.AbstractCrudController;

@RestController
@RequestMapping("/firms")
public class FirmController extends AbstractCrudController<
		FirmDto, FirmCreateRequest, FirmUpdateRequest, Long> {

	private final FirmService firmService;

	public FirmController(FirmService firmService) {
		super(firmService);
		this.firmService = firmService;
	}
}
