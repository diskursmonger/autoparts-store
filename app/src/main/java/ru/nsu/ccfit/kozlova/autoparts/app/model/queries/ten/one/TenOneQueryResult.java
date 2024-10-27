package ru.nsu.ccfit.kozlova.autoparts.app.model.queries.ten.one;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.nsu.ccfit.kozlova.autoparts.app.model.queries.QueryResult;
import ru.nsu.ccfit.kozlova.autoparts.app.utils.LocalDateFormatter;

import java.time.LocalDate;
import java.util.*;

@Getter @Setter
@NoArgsConstructor
public class TenOneQueryResult implements QueryResult {

	private Long detailTypeId;
	private Long amount;
	private Date deliveryDate;
	private Date customerRefundDate;
	private Long supplierId;

	private String deliveryDateProperty;
	private String customerRefundDateProperty;

	private static final Map<String, String> propertyNames = new LinkedHashMap<>();

	static {
		propertyNames.put("detailTypeId", "№ типа деталей");
		propertyNames.put("amount", "Количество деталей");
		propertyNames.put("deliveryDateProperty", "Дата доставки");
		propertyNames.put("customerRefundDateProperty", "Дата возврата покупателем");
		propertyNames.put("supplierId", "№ поставщика");
	}

	@Override
	public void calculateProperties() {
		deliveryDateProperty = Optional.ofNullable(deliveryDate).map(LocalDateFormatter::getFormattedDate).orElse(null);
		customerRefundDateProperty = Optional.ofNullable(customerRefundDate).map(LocalDateFormatter::getFormattedDate).orElse(null);
	}

	public static Map<String, String> getPropertyNames() {
		return Collections.unmodifiableMap(propertyNames);
	}

}

