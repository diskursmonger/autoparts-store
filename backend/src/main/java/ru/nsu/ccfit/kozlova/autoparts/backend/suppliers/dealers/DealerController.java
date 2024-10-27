package ru.nsu.ccfit.kozlova.autoparts.backend.suppliers.dealers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.suppliers.dealers.DealerCreateRequest;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.suppliers.dealers.DealerDto;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.suppliers.dealers.DealerUpdateRequest;
import ru.nsu.ccfit.kozlova.autoparts.backend.crud.controller.AbstractCrudController;

@RestController
@RequestMapping("/dealers")
public class DealerController extends AbstractCrudController<
		DealerDto, DealerCreateRequest, DealerUpdateRequest, Long> {

	private final DealerService dealerService;

	public DealerController(DealerService dealerService) {
		super(dealerService);
		this.dealerService = dealerService;
	}
}
