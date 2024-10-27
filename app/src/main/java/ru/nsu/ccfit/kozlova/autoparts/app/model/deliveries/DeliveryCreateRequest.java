package ru.nsu.ccfit.kozlova.autoparts.app.model.deliveries;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.Date;

@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class DeliveryCreateRequest {

	private Double discountPercent;

	private Date formationDate;

	private Date deliveryDate;

	private Long supplierId;

}
