package ru.nsu.ccfit.kozlova.autoparts.app.model.suppliers.shops;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import ru.nsu.ccfit.kozlova.autoparts.app.model.Entity;
import ru.nsu.ccfit.kozlova.autoparts.app.model.suppliers.SupplierDto;
import ru.nsu.ccfit.kozlova.autoparts.app.model.suppliers.smallproductions.SmallProductionDto;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class ShopDto extends SupplierDto {

	private String address;

	@Override
	public ShopDto clone() {
		ShopDto clone = (ShopDto) super.clone();
		clone.setAddress(address);
		return clone;
	}

	private static final Map<String, String> propertyNames = new LinkedHashMap<>();
	private static final Map<String, String> sortPropertyNames = new LinkedHashMap<>();

	static {
		propertyNames.putAll(SupplierDto.getPropertyNames());
		propertyNames.put("address", "Адрес");

		sortPropertyNames.putAll(SupplierDto.getSortPropertyNames());
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
