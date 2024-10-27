package ru.nsu.ccfit.kozlova.autoparts.app.model.sales;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import ru.nsu.ccfit.kozlova.autoparts.app.model.Entity;
import ru.nsu.ccfit.kozlova.autoparts.app.model.details.DetailDto;
import ru.nsu.ccfit.kozlova.autoparts.app.model.sales.customers.CustomerDto;
import ru.nsu.ccfit.kozlova.autoparts.app.model.sales.orders.OrderDto;
import ru.nsu.ccfit.kozlova.autoparts.app.model.suppliers.firms.FirmDto;
import ru.nsu.ccfit.kozlova.autoparts.app.utils.LocalDateFormatter;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class SaleDto extends Entity {

	private Date saleDate;
	private CustomerDto customer;
	private OrderDto order;
	private Set<DetailDto> details;

	private String saleDateProperty;
	private String customerNameProperty;
	private Integer detailsNumberProperty;
	private Long orderIdProperty;

	@Override
	public SaleDto clone() {
		SaleDto clone = (SaleDto) super.clone();
		clone.setSaleDate(saleDate);
		clone.setCustomer(customer.clone());
		clone.setOrder(Optional.ofNullable(order).map(OrderDto::clone).orElse(null));
		clone.setDetails(details.stream().map(DetailDto::clone).collect(Collectors.toSet()));
		return clone;
	}

	private static final Map<String, String> propertyNames = new LinkedHashMap<>();
	private static final Map<String, String> sortPropertyNames = new LinkedHashMap<>();

	static {
		propertyNames.putAll(Entity.getPropertyNames());
		propertyNames.put("saleDateProperty", "Дата покупки");
		propertyNames.put("customerNameProperty", "ФИО покупателя");
		propertyNames.put("detailsNumberProperty", "Число деталей");
		propertyNames.put("orderIdProperty", "№ заказа");

		sortPropertyNames.putAll(Entity.getSortPropertyNames());
		sortPropertyNames.put("saleDate", "Дата покупки");
	}

	@Override
	public void calculateProperties() {
		super.calculateProperties();
		saleDateProperty = LocalDateFormatter.getFormattedDate(saleDate);
		customerNameProperty = customer.getName();
		detailsNumberProperty = details.size();
		orderIdProperty = Optional.ofNullable(order).map(OrderDto::getId).orElse(null);
	}

	public static Map<String, String> getPropertyNames() {
		return Collections.unmodifiableMap(propertyNames);
	}

	public static Map<String, String> getSortPropertyNames() {
		return Collections.unmodifiableMap(sortPropertyNames);
	}
	
}
