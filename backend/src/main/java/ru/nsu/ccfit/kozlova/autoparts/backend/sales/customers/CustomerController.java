package ru.nsu.ccfit.kozlova.autoparts.backend.sales.customers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.sales.customers.CustomerCreateRequest;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.sales.customers.CustomerDto;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.sales.customers.CustomerUpdateRequest;
import ru.nsu.ccfit.kozlova.autoparts.backend.crud.controller.AbstractCrudController;

@RestController
@RequestMapping("/customers")
public class CustomerController extends AbstractCrudController<
		CustomerDto, CustomerCreateRequest, CustomerUpdateRequest, Long> {

	private final CustomerService customerService;

	public CustomerController(CustomerService customerService) {
		super(customerService);
		this.customerService = customerService;
	}
}
