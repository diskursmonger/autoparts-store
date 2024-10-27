package ru.nsu.ccfit.kozlova.autoparts.app.model.queries.three.three;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.nsu.ccfit.kozlova.autoparts.app.model.queries.QueryResult;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

@Getter @Setter
@NoArgsConstructor
public class ThreeThreeQueryResult implements QueryResult {

	private Long customerId;
	private Integer boughtDetAmount;

	private static final Map<String, String> propertyNames = new LinkedHashMap<>();

	static {
		propertyNames.put("customerId", "№ покупателя");
		propertyNames.put("boughtDetAmount", "Количество купленных деталей");
	}

	@Override
	public void calculateProperties() {

	}

	public static Map<String, String> getPropertyNames() {
		return Collections.unmodifiableMap(propertyNames);
	}

}

