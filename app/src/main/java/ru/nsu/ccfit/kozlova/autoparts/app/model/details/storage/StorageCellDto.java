package ru.nsu.ccfit.kozlova.autoparts.app.model.details.storage;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import ru.nsu.ccfit.kozlova.autoparts.app.model.Entity;
import ru.nsu.ccfit.kozlova.autoparts.app.model.details.DetailDto;
import ru.nsu.ccfit.kozlova.autoparts.app.model.sales.SaleDto;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class StorageCellDto extends Entity {

	private Set<DetailDto> details;

	private Integer detailsNumberProperty;

	@Override
	public StorageCellDto clone() {
		StorageCellDto clone = (StorageCellDto) super.clone();
		clone.setDetails(details.stream().map(DetailDto::clone).collect(Collectors.toSet()));
		return clone;
	}

	private static final Map<String, String> propertyNames = new LinkedHashMap<>();
	private static final Map<String, String> sortPropertyNames = new LinkedHashMap<>();

	static {
		propertyNames.putAll(Entity.getPropertyNames());
		propertyNames.put("detailsNumberProperty", "Число деталей");

		sortPropertyNames.putAll(Entity.getSortPropertyNames());
	}

	@Override
	public void calculateProperties() {
		super.calculateProperties();
		detailsNumberProperty = details.size();
	}

	public static Map<String, String> getPropertyNames() {
		return Collections.unmodifiableMap(propertyNames);
	}

	public static Map<String, String> getSortPropertyNames() {
		return Collections.unmodifiableMap(sortPropertyNames);
	}

}
