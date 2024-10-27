package ru.nsu.ccfit.kozlova.autoparts.app.model.queries.twelve.one;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.nsu.ccfit.kozlova.autoparts.app.model.queries.QueryResult;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

@Getter @Setter
@NoArgsConstructor
public class TwelveOneQueryResult implements QueryResult {

	private Double turnover;

	private static final Map<String, String> propertyNames = new LinkedHashMap<>();

	static {
		propertyNames.put("turnover", "Оборот магазина");
	}

	@Override
	public void calculateProperties() {

	}

	public static Map<String, String> getPropertyNames() {
		return Collections.unmodifiableMap(propertyNames);
	}

}

