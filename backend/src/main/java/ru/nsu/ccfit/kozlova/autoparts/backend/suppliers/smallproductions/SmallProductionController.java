package ru.nsu.ccfit.kozlova.autoparts.backend.suppliers.smallproductions;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.suppliers.smallproductions.SmallProductionCreateRequest;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.suppliers.smallproductions.SmallProductionDto;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.suppliers.smallproductions.SmallProductionUpdateRequest;
import ru.nsu.ccfit.kozlova.autoparts.backend.crud.controller.AbstractCrudController;

@RestController
@RequestMapping("/small-productions")
public class SmallProductionController extends AbstractCrudController<
		SmallProductionDto, SmallProductionCreateRequest, SmallProductionUpdateRequest, Long> {

	private final SmallProductionService smallProductionService;

	public SmallProductionController(SmallProductionService smallProductionService) {
		super(smallProductionService);
		this.smallProductionService = smallProductionService;
	}
}
