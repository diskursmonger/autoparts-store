package ru.nsu.ccfit.kozlova.autoparts.app.model.queries.thirteen;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.nsu.ccfit.kozlova.autoparts.app.model.queries.QueryResult;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

@Getter @Setter
@NoArgsConstructor
public class ThirteenQueryResult implements QueryResult {

	private Long detailTypeId;
	private String name;
	private Long detailTypesAmount;
	private Double shopPrice;

	private static final Map<String, String> propertyNames = new LinkedHashMap<>();

	static {
		propertyNames.put("detailTypeId", "№ типа детали");
		propertyNames.put("name", "Название");
		propertyNames.put("detailTypesAmount", "Число на складе");
		propertyNames.put("shopPrice", "Цена в магазине");
	}

	@Override
	public void calculateProperties() {

	}

	public static Map<String, String> getPropertyNames() {
		return Collections.unmodifiableMap(propertyNames);
	}

}

