package ru.nsu.ccfit.kozlova.autoparts.app.model.details.types;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import ru.nsu.ccfit.kozlova.autoparts.app.model.Entity;
import ru.nsu.ccfit.kozlova.autoparts.app.model.sales.SaleDto;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class DetailTypeDto extends Entity {

	private String name;
	private Double shopPrice;

	@Override
	public DetailTypeDto clone() {
		DetailTypeDto clone = (DetailTypeDto) super.clone();
		clone.setName(name);
		clone.setShopPrice(shopPrice);
		return clone;
	}

	private static final Map<String, String> propertyNames = new LinkedHashMap<>();
	private static final Map<String, String> sortPropertyNames = new LinkedHashMap<>();

	static {
		propertyNames.putAll(Entity.getPropertyNames());
		propertyNames.put("name", "Наименование");
		propertyNames.put("shopPrice", "Цена");

		sortPropertyNames.putAll(Entity.getSortPropertyNames());
		sortPropertyNames.put("name", "Наименование");
	}

	@Override
	public void calculateProperties() {
		super.calculateProperties();
	}

	public static Map<String, String> getPropertyNames() {
		return Collections.unmodifiableMap(propertyNames);
	}

	public static Map<String, String> getSortPropertyNames() {
		return Collections.unmodifiableMap(sortPropertyNames);
	}

}
