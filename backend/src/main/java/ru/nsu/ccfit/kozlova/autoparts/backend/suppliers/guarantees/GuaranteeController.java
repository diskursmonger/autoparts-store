package ru.nsu.ccfit.kozlova.autoparts.backend.suppliers.guarantees;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.suppliers.guarantees.GuaranteeCreateRequest;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.suppliers.guarantees.GuaranteeDto;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.suppliers.guarantees.GuaranteeUpdateRequest;
import ru.nsu.ccfit.kozlova.autoparts.backend.crud.controller.AbstractCrudController;

@RestController
@RequestMapping("/guarantees")
public class GuaranteeController extends AbstractCrudController<
		GuaranteeDto, GuaranteeCreateRequest, GuaranteeUpdateRequest, Long> {

	private final GuaranteeService guaranteeService;

	public GuaranteeController(GuaranteeService guaranteeService) {
		super(guaranteeService);
		this.guaranteeService = guaranteeService;
	}
}
