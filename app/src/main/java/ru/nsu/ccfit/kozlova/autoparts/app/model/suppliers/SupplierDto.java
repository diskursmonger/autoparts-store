package ru.nsu.ccfit.kozlova.autoparts.app.model.suppliers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import ru.nsu.ccfit.kozlova.autoparts.app.model.Entity;
import ru.nsu.ccfit.kozlova.autoparts.app.model.suppliers.guarantees.GuaranteeDto;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class SupplierDto extends Entity {

	private String name;
	private Set<GuaranteeDto> guarantees;

	@Override
	public SupplierDto clone() {
		SupplierDto clone = (SupplierDto) super.clone();
		clone.setName(name);
		clone.setGuarantees(guarantees.stream().map(GuaranteeDto::clone).collect(Collectors.toSet()));
		return clone;
	}

	private static final Map<String, String> propertyNames = new LinkedHashMap<>();
	private static final Map<String, String> sortPropertyNames = new LinkedHashMap<>();

	static {
		propertyNames.putAll(Entity.getPropertyNames());
		propertyNames.put("name", "Название организации");

		sortPropertyNames.putAll(Entity.getSortPropertyNames());
		sortPropertyNames.put("name", "Название организации");
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
