package ru.nsu.ccfit.kozlova.autoparts.backend.sales.customers;

import org.springframework.stereotype.Service;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.sales.customers.CustomerCreateRequest;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.sales.customers.CustomerDto;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.sales.customers.CustomerUpdateRequest;
import ru.nsu.ccfit.kozlova.autoparts.backend.crud.service.AbstractCrudService;

@Service
public class CustomerService extends AbstractCrudService<
		Customer, CustomerDto, CustomerCreateRequest, CustomerUpdateRequest, Long> {

	private final CustomerRepository customerRepository;
	private final CustomerMapper customerMapper;

	public CustomerService(
			CustomerRepository customerRepository,
			CustomerMapper customerMapper
	) {
		super(customerRepository, customerMapper);
		this.customerRepository = customerRepository;
		this.customerMapper = customerMapper;
	}
}
