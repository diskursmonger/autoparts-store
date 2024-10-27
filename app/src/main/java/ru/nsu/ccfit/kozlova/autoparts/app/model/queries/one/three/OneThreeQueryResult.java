package ru.nsu.ccfit.kozlova.autoparts.app.model.queries.one.three;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.nsu.ccfit.kozlova.autoparts.app.model.queries.QueryResult;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

@Getter @Setter
@NoArgsConstructor
public class OneThreeQueryResult implements QueryResult {

	private Long supplierId;
	private Long detailTypeId;
	private Long deliveryId;
	private Integer detailsAmount;

	private static final Map<String, String> propertyNames = new LinkedHashMap<>();

	static {
		propertyNames.put("supplierId", "№ поставщика");
		propertyNames.put("detailTypeId", "№ типа детали");
		propertyNames.put("deliveryId", "№ поставки");
		propertyNames.put("detailsAmount", "Количество деталей");
	}

	@Override
	public void calculateProperties() {

	}

	public static Map<String, String> getPropertyNames() {
		return Collections.unmodifiableMap(propertyNames);
	}

}

