package ru.nsu.ccfit.kozlova.autoparts.app.model.queries.sixteen.three;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.nsu.ccfit.kozlova.autoparts.app.model.queries.QueryResult;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

@Getter @Setter
@NoArgsConstructor
public class SixteenThreeQueryResult implements QueryResult {

	private Integer amount;
	private Long detTypeId;
	private Long orderId;
	private Double sumShopPrice;

	private static final Map<String, String> propertyNames = new LinkedHashMap<>();

	static {
		propertyNames.put("amount", "Количество деталей");
		propertyNames.put("detTypeId", "№ типа детали");
		propertyNames.put("orderId", "№ заказа");
		propertyNames.put("sumShopPrice", "Сумма денег");
	}

	@Override
	public void calculateProperties() {

	}

	public static Map<String, String> getPropertyNames() {
		return Collections.unmodifiableMap(propertyNames);
	}

}

