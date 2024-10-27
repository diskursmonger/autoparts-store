package ru.nsu.ccfit.kozlova.autoparts.backend.model.queries.two;

import lombok.*;

@Getter @Setter
@NoArgsConstructor
public class TwoQueryResult {

	private Long supplierId;

	private Double averageSupplierPrice;

	private Double averageDelivery;

}

