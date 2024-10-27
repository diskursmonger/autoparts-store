package ru.nsu.ccfit.kozlova.autoparts.backend.details.types;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.details.types.DetailTypeCreateRequest;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.details.types.DetailTypeDto;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.details.types.DetailTypeUpdateRequest;
import ru.nsu.ccfit.kozlova.autoparts.backend.crud.controller.AbstractCrudController;

@RestController
@RequestMapping("/detail-types")
public class DetailTypeController extends AbstractCrudController<
		DetailTypeDto, DetailTypeCreateRequest, DetailTypeUpdateRequest, Long> {

	private final DetailTypeService detailTypeService;

	public DetailTypeController(DetailTypeService detailTypeService) {
		super(detailTypeService);
		this.detailTypeService = detailTypeService;
	}
}
