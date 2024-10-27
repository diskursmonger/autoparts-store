package ru.nsu.ccfit.kozlova.autoparts.backend.sales;

import org.springframework.stereotype.Component;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.details.DetailDto;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.sales.SaleCreateRequest;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.sales.SaleDto;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.sales.SaleUpdateRequest;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.sales.customers.CustomerDto;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.sales.orders.OrderDto;
import ru.nsu.ccfit.kozlova.autoparts.backend.crud.data.Mapper;
import ru.nsu.ccfit.kozlova.autoparts.backend.details.DetailMapper;
import ru.nsu.ccfit.kozlova.autoparts.backend.sales.customers.Customer;
import ru.nsu.ccfit.kozlova.autoparts.backend.sales.customers.CustomerMapper;
import ru.nsu.ccfit.kozlova.autoparts.backend.sales.customers.CustomerRepository;
import ru.nsu.ccfit.kozlova.autoparts.backend.sales.orders.Order;
import ru.nsu.ccfit.kozlova.autoparts.backend.sales.orders.OrderMapper;
import ru.nsu.ccfit.kozlova.autoparts.backend.sales.orders.OrderRepository;
import static ru.nsu.ccfit.kozlova.autoparts.backend.crud.data.MapperUtils.setIfNotNull;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class SaleMapper implements Mapper<Sale, SaleDto, SaleCreateRequest, SaleUpdateRequest> {

	private final DetailMapper detailMapper;
	private final CustomerMapper customerMapper;
	private final OrderMapper orderMapper;

	private final OrderRepository orderRepository;
	private final CustomerRepository customerRepository;


	public SaleMapper(
			DetailMapper detailMapper,
			CustomerMapper customerMapper,
			OrderMapper orderMapper,
			OrderRepository orderRepository,
			CustomerRepository customerRepository
	) {
		this.detailMapper = detailMapper;
		this.customerMapper = customerMapper;
		this.orderMapper = orderMapper;
		this.orderRepository = orderRepository;
		this.customerRepository = customerRepository;
	}

	@Override
	public Sale createEntity(SaleCreateRequest createRequest) {
		Customer customer = customerRepository.getById(createRequest.getCustomerId());
		Order order = null;
		if (createRequest.getOrderId() != null) {
			order = orderRepository.getById(createRequest.getOrderId());
		}

		return Sale.builder()
				.saleDate(createRequest.getSaleDate())
				.customer(customer)
				.order(order)
				.build();
	}

	@Override
	public void updateEntity(Sale sale, SaleUpdateRequest updateRequest) {
		setIfNotNull(updateRequest.getSaleDate(), sale::setSaleDate);
		setIfNotNull(updateRequest.getCustomerId(), customerId -> {
			Customer customer = customerRepository.getById(customerId);
			sale.setCustomer(customer);
		});
		setIfNotNull(updateRequest.getOrderId(), orderId -> {
			Order order = orderRepository.getById(orderId);
			sale.setOrder(order);
		});
	}

	@Override
	public SaleDto toDto(Sale sale) {
		Set<DetailDto> details = sale.getDetails()
				.stream()
				.map(detailMapper::toDto)
				.collect(Collectors.toSet());

		CustomerDto customer = customerMapper.toDto(sale.getCustomer());
		OrderDto order = Optional.ofNullable(sale.getOrder())
				.map(orderMapper::toDto)
				.orElse(null);

		return SaleDto.builder()
				.id(sale.getId())
				.saleDate(sale.getSaleDate())
				.customer(customer)
				.order(order)
				.details(details)
				.build();
	}
}
