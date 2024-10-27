package ru.nsu.ccfit.kozlova.autoparts.app.model.queries.one.one;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.nsu.ccfit.kozlova.autoparts.app.model.Entity;
import ru.nsu.ccfit.kozlova.autoparts.app.model.queries.QueryResult;
import ru.nsu.ccfit.kozlova.autoparts.app.model.sales.orders.OrderDetailTypeAmountDto;
import ru.nsu.ccfit.kozlova.autoparts.app.utils.LocalDateFormatter;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

@Getter @Setter
@NoArgsConstructor
public class OneOneQueryResult implements QueryResult {

	private Long supplierId;

	private static final Map<String, String> propertyNames = new LinkedHashMap<>();

	static {
		propertyNames.put("supplierId", "№ поставщика");
	}

	@Override
	public void calculateProperties() { }

	public static Map<String, String> getPropertyNames() {
		return Collections.unmodifiableMap(propertyNames);
	}

}

