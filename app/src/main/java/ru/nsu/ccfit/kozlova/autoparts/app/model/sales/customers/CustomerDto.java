package ru.nsu.ccfit.kozlova.autoparts.app.model.sales.customers;

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
public class CustomerDto extends Entity {

	private String name;

	@Override
	public CustomerDto clone() {
		CustomerDto clone = (CustomerDto) super.clone();
		clone.setName(name);
		return clone;
	}

	private static final Map<String, String> propertyNames = new LinkedHashMap<>();
	private static final Map<String, String> sortPropertyNames = new LinkedHashMap<>();

	static {
		propertyNames.putAll(Entity.getPropertyNames());
		propertyNames.put("name", "ФИО");

		sortPropertyNames.putAll(Entity.getSortPropertyNames());
		sortPropertyNames.put("name", "ФИО");
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
