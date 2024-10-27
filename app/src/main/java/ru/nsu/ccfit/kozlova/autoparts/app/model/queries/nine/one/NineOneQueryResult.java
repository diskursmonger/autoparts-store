package ru.nsu.ccfit.kozlova.autoparts.app.model.queries.nine.one;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.nsu.ccfit.kozlova.autoparts.app.model.queries.QueryResult;
import ru.nsu.ccfit.kozlova.autoparts.app.utils.LocalDateFormatter;

import java.time.LocalDate;
import java.util.*;

@Getter @Setter
@NoArgsConstructor
public class NineOneQueryResult implements QueryResult {

	private Long id;
	private Long detailTypeId;
	private Date deliveryDate;
	private Date saleDate;

	private String deliveryDateProperty;
	private String saleDateProperty;

	private static final Map<String, String> propertyNames = new LinkedHashMap<>();

	static {
		propertyNames.put("id", "№");
		propertyNames.put("detailTypeId", "№ типа детали");
		propertyNames.put("deliveryDateProperty", "Дата доставки");
		propertyNames.put("saleDateProperty", "Дата продажи");
	}

	@Override
	public void calculateProperties() {
		deliveryDateProperty = Optional.ofNullable(deliveryDate).map(LocalDateFormatter::getFormattedDate).orElse(null);
		saleDateProperty = Optional.ofNullable(saleDate).map(LocalDateFormatter::getFormattedDate).orElse(null);
	}

	public static Map<String, String> getPropertyNames() {
		return Collections.unmodifiableMap(propertyNames);
	}

}

