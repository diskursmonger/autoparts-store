package ru.nsu.ccfit.kozlova.autoparts.app.services.suppliers.guarantees;

import ru.nsu.ccfit.kozlova.autoparts.app.model.suppliers.guarantees.GuaranteeCreateRequest;
import ru.nsu.ccfit.kozlova.autoparts.app.model.suppliers.guarantees.GuaranteeDto;
import ru.nsu.ccfit.kozlova.autoparts.app.model.suppliers.guarantees.GuaranteeUpdateRequest;
import ru.nsu.ccfit.kozlova.autoparts.app.services.crud.AbstractCrudService;

public class GuaranteeService
		extends AbstractCrudService<GuaranteeDto, GuaranteeCreateRequest, GuaranteeUpdateRequest> {

	public GuaranteeService(String baseUrl) {
		super(GuaranteeServiceApi.class, GuaranteeDto.class, baseUrl, "guarantees");
	}

}
