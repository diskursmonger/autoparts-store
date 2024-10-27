package ru.nsu.ccfit.kozlova.autoparts.app.model.queries.four.three;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.nsu.ccfit.kozlova.autoparts.app.model.queries.QueryResult;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

@Getter @Setter
@NoArgsConstructor
public class FourThreeQueryResult implements QueryResult {

	private Long cellId;
	private Long id;
	private Long detailTypeId;

	private static final Map<String, String> propertyNames = new LinkedHashMap<>();

	static {
		propertyNames.put("cellId", "№ ячейки");
		propertyNames.put("id", "№ детали");
		propertyNames.put("detailTypeId", "№ типа детали");
	}

	@Override
	public void calculateProperties() {

	}

	public static Map<String, String> getPropertyNames() {
		return Collections.unmodifiableMap(propertyNames);
	}

}

