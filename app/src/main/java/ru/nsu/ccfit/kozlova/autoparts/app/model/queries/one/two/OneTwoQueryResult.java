package ru.nsu.ccfit.kozlova.autoparts.app.model.queries.one.two;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.nsu.ccfit.kozlova.autoparts.app.model.queries.QueryResult;
import ru.nsu.ccfit.kozlova.autoparts.app.utils.LocalDateFormatter;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

@Getter @Setter
@NoArgsConstructor
public class OneTwoQueryResult implements QueryResult {

	private Integer suppliersAmount;

	private static final Map<String, String> propertyNames = new LinkedHashMap<>();

	static {
		propertyNames.put("suppliersAmount", "Количество поставщиков");
	}

	@Override
	public void calculateProperties() {

	}

	public static Map<String, String> getPropertyNames() {
		return Collections.unmodifiableMap(propertyNames);
	}
}

