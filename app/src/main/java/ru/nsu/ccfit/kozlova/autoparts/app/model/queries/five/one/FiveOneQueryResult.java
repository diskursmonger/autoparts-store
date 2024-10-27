package ru.nsu.ccfit.kozlova.autoparts.app.model.queries.five.one;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.nsu.ccfit.kozlova.autoparts.app.model.queries.QueryResult;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

@Getter @Setter
@NoArgsConstructor
public class FiveOneQueryResult implements QueryResult {

	private Long detailTypeId;
	private Integer soldDetailTypeAmount;

	private static final Map<String, String> propertyNames = new LinkedHashMap<>();

	static {
		propertyNames.put("detailTypeId", "№ тиипа детали");
		propertyNames.put("soldDetailTypeAmount", "Количество проданных деталей");
	}

	@Override
	public void calculateProperties() {

	}

	public static Map<String, String> getPropertyNames() {
		return Collections.unmodifiableMap(propertyNames);
	}

}

