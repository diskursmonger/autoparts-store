package ru.nsu.ccfit.kozlova.autoparts.app.model.queries.eleven.one;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.nsu.ccfit.kozlova.autoparts.app.model.queries.QueryResult;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

@Getter @Setter
@NoArgsConstructor
public class ElevenOneQueryResult implements QueryResult {

	private Long detailTypeId;
	private Long detailsAmount;
	private Double sumShopPrice;

	private static final Map<String, String> propertyNames = new LinkedHashMap<>();

	static {
		propertyNames.put("detailTypeId", "№ типа детали");
		propertyNames.put("detailsAmount", "Количество деталей");
		propertyNames.put("sumShopPrice", "Общая стоимость");
	}

	public void calculateProperties() {

	}

	public static Map<String, String> getPropertyNames() {
		return Collections.unmodifiableMap(propertyNames);
	}

}

