package ru.nsu.ccfit.kozlova.autoparts.app.model.sales.orders;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import ru.nsu.ccfit.kozlova.autoparts.app.model.Entity;
import ru.nsu.ccfit.kozlova.autoparts.app.model.sales.SaleDto;
import ru.nsu.ccfit.kozlova.autoparts.app.model.sales.customers.CustomerDto;
import ru.nsu.ccfit.kozlova.autoparts.app.utils.LocalDateFormatter;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class OrderDto extends Entity {

	private Date orderDate;
	private CustomerDto customer;
	private Set<OrderDetailTypeAmountDto> detailTypeAmounts;

	private String orderDateProperty;
	private String customerNameProperty;
	private Integer detailsAmountProperty;

	@Override
	public OrderDto clone() {
		OrderDto clone = (OrderDto) super.clone();
		clone.setOrderDate(orderDate);
		clone.setCustomer(customer.clone());
		clone.setDetailTypeAmounts(
				detailTypeAmounts.stream()
						.map(OrderDetailTypeAmountDto::clone)
						.collect(Collectors.toSet())
		);
		return clone;
	}

	private static final Map<String, String> propertyNames = new LinkedHashMap<>();
	private static final Map<String, String> sortPropertyNames = new LinkedHashMap<>();

	static {
		propertyNames.putAll(Entity.getPropertyNames());
		propertyNames.put("orderDateProperty", "Дата заказа");
		propertyNames.put("customerNameProperty", "ФИО заказчика");
		propertyNames.put("detailsAmountProperty", "Число деталей");

		sortPropertyNames.putAll(Entity.getSortPropertyNames());
		sortPropertyNames.put("orderDate", "Дата заказа");
	}

	@Override
	public void calculateProperties() {
		super.calculateProperties();
		orderDateProperty = LocalDateFormatter.getFormattedDate(orderDate);
		customerNameProperty = customer.getName();
		detailsAmountProperty = detailTypeAmounts.stream()
				.map(OrderDetailTypeAmountDto::getAmount)
				.reduce(Integer::sum)
				.orElse(0);
	}

	public static Map<String, String> getPropertyNames() {
		return Collections.unmodifiableMap(propertyNames);
	}

	public static Map<String, String> getSortPropertyNames() {
		return Collections.unmodifiableMap(sortPropertyNames);
	}

}
