package ru.nsu.ccfit.kozlova.autoparts.backend.sales.customers;

import org.springframework.stereotype.Component;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.sales.customers.CustomerCreateRequest;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.sales.customers.CustomerDto;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.sales.customers.CustomerUpdateRequest;
import ru.nsu.ccfit.kozlova.autoparts.backend.crud.data.Mapper;
import static ru.nsu.ccfit.kozlova.autoparts.backend.crud.data.MapperUtils.setIfNotNull;

@Component
public class CustomerMapper implements Mapper<Customer, CustomerDto, CustomerCreateRequest, CustomerUpdateRequest> {
	@Override
	public Customer createEntity(CustomerCreateRequest createRequest) {
		return Customer.builder()
				.name(createRequest.getName())
				.build();
	}

	@Override
	public void updateEntity(Customer customer, CustomerUpdateRequest updateRequest) {
		setIfNotNull(updateRequest.getName(), customer::setName);
	}

	@Override
	public CustomerDto toDto(Customer customer) {
		return CustomerDto.builder()
				.id(customer.getId())
				.name(customer.getName())
				.build();
	}
}
