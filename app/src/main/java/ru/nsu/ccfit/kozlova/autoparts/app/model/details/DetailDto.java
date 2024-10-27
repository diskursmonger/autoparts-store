package ru.nsu.ccfit.kozlova.autoparts.app.model.details;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import ru.nsu.ccfit.kozlova.autoparts.app.model.Entity;
import ru.nsu.ccfit.kozlova.autoparts.app.model.details.types.DetailTypeDto;
import ru.nsu.ccfit.kozlova.autoparts.app.model.sales.SaleDto;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class DetailDto extends Entity {

	private Long storageCellId;
	private Long deliveryId;
	private DetailTypeDto detailType;
	private RefundDto refund;

	private String detailTypeNameProperty;
	private String isDefectiveProperty;

	@Override
	public DetailDto clone() {
		DetailDto clone = (DetailDto) super.clone();
		clone.setStorageCellId(storageCellId);
		clone.setDeliveryId(deliveryId);
		clone.setDetailType(detailType.clone());
		clone.setRefund(Optional.ofNullable(refund).map(RefundDto::clone).orElse(null));
		return clone;
	}

	private static final Map<String, String> propertyNames = new LinkedHashMap<>();
	private static final Map<String, String> sortPropertyNames = new LinkedHashMap<>();

	static {
		propertyNames.putAll(Entity.getPropertyNames());
		propertyNames.put("detailTypeNameProperty", "Тип детали");
		propertyNames.put("deliveryId", "№ поставки");
		propertyNames.put("storageCellId", "№ ячейки склада");
		propertyNames.put("isDefectiveProperty", "Брак");

		sortPropertyNames.putAll(Entity.getSortPropertyNames());
		sortPropertyNames.put("deliveryId", "№ поставки");
		sortPropertyNames.put("storageCellId", "№ ячейки склада");
	}

	@Override
	public void calculateProperties() {
		super.calculateProperties();
		detailTypeNameProperty = detailType.getName();
		isDefectiveProperty = (refund == null) ? "Нет" : "Да";
	}

	public static Map<String, String> getPropertyNames() {
		return Collections.unmodifiableMap(propertyNames);
	}

	public static Map<String, String> getSortPropertyNames() {
		return Collections.unmodifiableMap(sortPropertyNames);
	}

}
