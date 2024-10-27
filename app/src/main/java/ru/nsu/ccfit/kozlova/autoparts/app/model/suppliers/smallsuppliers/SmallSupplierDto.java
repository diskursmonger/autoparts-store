package ru.nsu.ccfit.kozlova.autoparts.app.model.suppliers.smallsuppliers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import ru.nsu.ccfit.kozlova.autoparts.app.model.Entity;
import ru.nsu.ccfit.kozlova.autoparts.app.model.suppliers.SupplierDto;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class SmallSupplierDto extends SupplierDto {

	private String phoneNumber;

	@Override
	public SmallSupplierDto clone() {
		SmallSupplierDto clone = (SmallSupplierDto) super.clone();
		clone.setPhoneNumber(phoneNumber);
		return clone;
	}

	private static final Map<String, String> propertyNames = new LinkedHashMap<>();
	private static final Map<String, String> sortPropertyNames = new LinkedHashMap<>();

	static {
		propertyNames.putAll(SupplierDto.getPropertyNames());
		propertyNames.put("phoneNumber", "Номер телефона");

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
