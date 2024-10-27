package ru.nsu.ccfit.kozlova.autoparts.app.model.queries.five.two;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.nsu.ccfit.kozlova.autoparts.app.model.queries.QueryResult;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

@Getter @Setter
@NoArgsConstructor
public class FiveTwoQueryResult implements QueryResult {

	private Long suppId;
	private Long detTypeId;
	private Double avgPrice;
	private Long soldDetTAmount;

	private static final Map<String, String> propertyNames = new LinkedHashMap<>();

	static {
		propertyNames.put("suppId", "№ поставщика");
		propertyNames.put("detTypeId", "№ типа детали");
		propertyNames.put("avgPrice", "Средняя цена");
		propertyNames.put("soldDetTAmount", "Количество проданных деталей");
	}

	@Override
	public void calculateProperties() {

	}

	public static Map<String, String> getPropertyNames() {
		return Collections.unmodifiableMap(propertyNames);
	}

}

