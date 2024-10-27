package ru.nsu.ccfit.kozlova.autoparts.app.model.suppliers.firms;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import ru.nsu.ccfit.kozlova.autoparts.app.model.Entity;
import ru.nsu.ccfit.kozlova.autoparts.app.model.suppliers.SupplierDto;
import ru.nsu.ccfit.kozlova.autoparts.app.model.suppliers.guarantees.GuaranteeDto;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class FirmDto extends SupplierDto {

	private String website;

	@Override
	public FirmDto clone() {
		FirmDto clone = (FirmDto) super.clone();
		clone.setWebsite(website);
		return clone;
	}

	private static final Map<String, String> propertyNames = new LinkedHashMap<>();
	private static final Map<String, String> sortPropertyNames = new LinkedHashMap<>();

	static {
		propertyNames.putAll(SupplierDto.getPropertyNames());
		propertyNames.put("website", "Веб-сайт");

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
