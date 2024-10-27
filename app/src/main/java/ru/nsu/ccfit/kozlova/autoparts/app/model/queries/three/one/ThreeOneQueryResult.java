package ru.nsu.ccfit.kozlova.autoparts.app.model.queries.three.one;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.nsu.ccfit.kozlova.autoparts.app.model.queries.QueryResult;
import ru.nsu.ccfit.kozlova.autoparts.app.utils.LocalDateFormatter;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

@Getter @Setter
@NoArgsConstructor
public class ThreeOneQueryResult implements QueryResult {

	private Long customerId;

	private String customerName;

	private Long saleId;

	private Long detailId;

	private Long detailTypeId;

	private Date saleDate;

	private String saleDateProperty;

	private static final Map<String, String> propertyNames = new LinkedHashMap<>();

	static {
		propertyNames.put("customerId", "№ покупателя");
		propertyNames.put("customerName", "Имя покупателя");
		propertyNames.put("saleId", "№ покупки");
		propertyNames.put("detailId", "№ детали");
		propertyNames.put("detailTypeId", "№ типа детали");
		propertyNames.put("saleDateProperty", "Дата продажи");
	}

	@Override
	public void calculateProperties() {
		saleDateProperty = LocalDateFormatter.getFormattedDate(saleDate);
	}

	public static Map<String, String> getPropertyNames() {
		return Collections.unmodifiableMap(propertyNames);
	}

}
