package ru.nsu.ccfit.kozlova.autoparts.app.model.suppliers.guarantees;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import ru.nsu.ccfit.kozlova.autoparts.app.model.Entity;
import ru.nsu.ccfit.kozlova.autoparts.app.model.details.types.DetailTypeDto;
import ru.nsu.ccfit.kozlova.autoparts.app.model.suppliers.shops.ShopDto;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class GuaranteeDto extends Entity {

	private Long supplierId;
	private DetailTypeDto detailType;
	private Integer guaranteeMonths;

	private String detailTypeNameProperty;

	@Override
	public GuaranteeDto clone() {
		GuaranteeDto clone = (GuaranteeDto) super.clone();
		clone.setSupplierId(supplierId);
		clone.setDetailType(detailType.clone());
		clone.setGuaranteeMonths(guaranteeMonths);
		return clone;
	}

	private static final Map<String, String> propertyNames = new LinkedHashMap<>();
	private static final Map<String, String> sortPropertyNames = new LinkedHashMap<>();

	static {
		propertyNames.putAll(Entity.getPropertyNames());
		propertyNames.put("supplierId", "№ поставщика");
		propertyNames.put("detailTypeNameProperty", "Тип детали");
		propertyNames.put("guaranteeMonths", "Срок гарантии, мес.");

		sortPropertyNames.putAll(Entity.getSortPropertyNames());
		sortPropertyNames.put("supplierId", "№ поставщика");
		sortPropertyNames.put("guaranteeMonths", "Срок гарантии, мес.");
	}

	@Override
	public void calculateProperties() {
		super.calculateProperties();
		detailTypeNameProperty = detailType.getName();
	}

	public static Map<String, String> getPropertyNames() {
		return Collections.unmodifiableMap(propertyNames);
	}

	public static Map<String, String> getSortPropertyNames() {
		return Collections.unmodifiableMap(sortPropertyNames);
	}

}
