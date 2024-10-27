package ru.nsu.ccfit.kozlova.autoparts.app.services.sales.customers;

import ru.nsu.ccfit.kozlova.autoparts.app.model.deliveries.CustomDto;
import ru.nsu.ccfit.kozlova.autoparts.app.model.sales.customers.CustomerCreateRequest;
import ru.nsu.ccfit.kozlova.autoparts.app.model.sales.customers.CustomerDto;
import ru.nsu.ccfit.kozlova.autoparts.app.model.sales.customers.CustomerUpdateRequest;
import ru.nsu.ccfit.kozlova.autoparts.app.services.crud.AbstractCrudService;

public class CustomerService extends AbstractCrudService<CustomerDto, CustomerCreateRequest, CustomerUpdateRequest> {

	public CustomerService(String baseUrl) {
		super(CustomerServiceApi.class, CustomerDto.class, baseUrl, "customers");
	}

}
