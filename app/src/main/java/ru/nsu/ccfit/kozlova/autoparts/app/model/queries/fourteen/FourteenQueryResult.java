package ru.nsu.ccfit.kozlova.autoparts.app.model.queries.fourteen;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.nsu.ccfit.kozlova.autoparts.app.model.queries.QueryResult;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

@Getter @Setter
@NoArgsConstructor
public class FourteenQueryResult implements QueryResult {

	private Long detTypeId;
	private Double circulationSpeed;

	private static final Map<String, String> propertyNames = new LinkedHashMap<>();

	static {
		propertyNames.put("detTypeId", "№ типа деталеи");
		propertyNames.put("circulationSpeed", "Скорость обращения денег");
	}

	@Override
	public void calculateProperties() {

	}

	public static Map<String, String> getPropertyNames() {
		return Collections.unmodifiableMap(propertyNames);
	}

}

