package ru.nsu.ccfit.kozlova.autoparts.app.model.queries.two;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.nsu.ccfit.kozlova.autoparts.app.model.queries.QueryResult;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

@Getter @Setter
@NoArgsConstructor
public class TwoQueryResult implements QueryResult {

	private Long supplierId;
	private Double averageSupplierPrice;
	private Double averageDelivery;

	private static final Map<String, String> propertyNames = new LinkedHashMap<>();

	static {
		propertyNames.put("supplierId", "№ поставщика");
		propertyNames.put("averageSupplierPrice", "Средняя расценка");
		propertyNames.put("averageDelivery", "Примерное время поставки");
	}

	@Override
	public void calculateProperties() { }

	public static Map<String, String> getPropertyNames() {
		return Collections.unmodifiableMap(propertyNames);
	}

}

