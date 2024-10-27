package ru.nsu.ccfit.kozlova.autoparts.app.model.deliveries;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import ru.nsu.ccfit.kozlova.autoparts.app.model.Entity;
import ru.nsu.ccfit.kozlova.autoparts.app.model.details.DetailDto;
import ru.nsu.ccfit.kozlova.autoparts.app.model.sales.SaleDto;
import ru.nsu.ccfit.kozlova.autoparts.app.model.suppliers.SupplierDto;
import ru.nsu.ccfit.kozlova.autoparts.app.utils.LocalDateFormatter;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class DeliveryDto extends Entity {

	private Double discountPercent;
	private Date formationDate;
	private Date deliveryDate;
	private SupplierDto supplier;
	private CustomDto custom;
	private Set<DetailDto> details;
	private Set<DeliveryDetailTypePriceDto> detailTypePrices;


	private String formationDateProperty;
	private String deliveryDateProperty;
	private String supplierNameProperty;
	private Integer detailTypesNumberProperty;
	private Integer detailsNumberProperty;
	private String isCustomImposedProperty;

	@Override
	public DeliveryDto clone() {
		DeliveryDto clone = (DeliveryDto) super.clone();
		clone.setDiscountPercent(discountPercent);
		clone.setFormationDate(formationDate);
		clone.setDeliveryDate(deliveryDate);
		clone.setSupplier(supplier.clone());
		clone.setCustom(custom.clone());
		clone.setDetails(details.stream().map(DetailDto::clone).collect(Collectors.toSet()));
		clone.setDetailTypePrices(
				detailTypePrices.stream()
						.map(DeliveryDetailTypePriceDto::clone)
						.collect(Collectors.toSet())
		);
		return clone;
	}

	private static final Map<String, String> propertyNames = new LinkedHashMap<>();
	private static final Map<String, String> sortPropertyNames = new LinkedHashMap<>();

	static {
		propertyNames.putAll(Entity.getPropertyNames());
		propertyNames.put("supplierNameProperty", "Поставщик");
		propertyNames.put("formationDateProperty", "Дата оформления");
		propertyNames.put("deliveryDateProperty", "Дата доставки");
		propertyNames.put("detailTypesNumberProperty", "Число типов деталей");
		propertyNames.put("detailsNumberProperty", "Число деталей");
		propertyNames.put("discountPercent", "Скидка, %");
		propertyNames.put("isCustomImposedProperty", "Пошлина");

		sortPropertyNames.putAll(Entity.getSortPropertyNames());
		sortPropertyNames.put("formationDate", "Дата оформления");
		sortPropertyNames.put("deliveryDate", "Дата доставки");
		sortPropertyNames.put("discountPercent", "Скидка, %");
	}

	@Override
	public void calculateProperties() {
		super.calculateProperties();
		formationDateProperty = LocalDateFormatter.getFormattedDate(formationDate);
		deliveryDateProperty = Optional.ofNullable(deliveryDate).map(LocalDateFormatter::getFormattedDate).orElse(null);
		supplierNameProperty = supplier.getName();
		detailTypesNumberProperty = detailTypePrices.size();
		detailsNumberProperty = details.size();
		isCustomImposedProperty = (custom == null) ? "Нет" : "Да";
	}

	public static Map<String, String> getPropertyNames() {
		return Collections.unmodifiableMap(propertyNames);
	}

	public static Map<String, String> getSortPropertyNames() {
		return Collections.unmodifiableMap(sortPropertyNames);
	}

}
