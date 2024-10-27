package ru.nsu.ccfit.kozlova.autoparts.backend.model.deliveries;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class DeliveryUpdateRequest {

	private Double discountPercent;

	private LocalDate formationDate;

	private LocalDate deliveryDate;

	private Long supplierId;

}
