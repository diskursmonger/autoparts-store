package ru.nsu.ccfit.kozlova.autoparts.backend.sales.orders;

import org.springframework.stereotype.Component;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.sales.customers.CustomerDto;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.sales.orders.*;
import ru.nsu.ccfit.kozlova.autoparts.backend.crud.data.Mapper;
import ru.nsu.ccfit.kozlova.autoparts.backend.details.types.DetailTypeMapper;
import ru.nsu.ccfit.kozlova.autoparts.backend.sales.customers.Customer;
import ru.nsu.ccfit.kozlova.autoparts.backend.sales.customers.CustomerMapper;
import ru.nsu.ccfit.kozlova.autoparts.backend.sales.customers.CustomerRepository;
import static ru.nsu.ccfit.kozlova.autoparts.backend.crud.data.MapperUtils.setIfNotNull;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class OrderMapper implements Mapper<Order, OrderDto, OrderCreateRequest, OrderUpdateRequest> {

	private final CustomerMapper customerMapper;
	private final DetailTypeMapper detailTypeMapper;
	private final CustomerRepository customerRepository;

	public OrderMapper(
			CustomerMapper customerMapper,
			DetailTypeMapper detailTypeMapper,
			CustomerRepository customerRepository
	) {
		this.customerMapper = customerMapper;
		this.detailTypeMapper = detailTypeMapper;
		this.customerRepository = customerRepository;
	}

	@Override
	public Order createEntity(OrderCreateRequest createRequest) {
		Customer customer = customerRepository.getById(createRequest.getCustomerId());
		return Order.builder()
				.orderDate(createRequest.getOrderDate())
				.customer(customer)
				.build();
	}

	@Override
	public void updateEntity(Order order, OrderUpdateRequest updateRequest) {
		setIfNotNull(updateRequest.getOrderDate(), order::setOrderDate);
		setIfNotNull(updateRequest.getCustomerId(), customerId -> {
			Customer customer = customerRepository.getById(customerId);
			order.setCustomer(customer);
		});
	}

	@Override
	public OrderDto toDto(Order order) {
		Set<OrderDetailTypeAmountDto> detailTypeAmounts = order.getOrderDetailTypeAmounts()
				.stream()
				.map(dta -> OrderDetailTypeAmountDto.builder()
						.detailType(detailTypeMapper.toDto(dta.getDetailType()))
						.amount(dta.getAmount())
						.build()
				).collect(Collectors.toSet());

		CustomerDto customer = customerMapper.toDto(order.getCustomer());

		return OrderDto.builder()
				.id(order.getId())
				.orderDate(order.getOrderDate())
				.customer(customer)
				.detailTypeAmounts(detailTypeAmounts)
				.build();
	}
}
