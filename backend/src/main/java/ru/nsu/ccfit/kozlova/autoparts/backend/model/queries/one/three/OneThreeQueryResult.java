package ru.nsu.ccfit.kozlova.autoparts.backend.model.queries.one.three;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class OneThreeQueryResult {

	private Long supplierId;
	private Long detailTypeId;
	private Long deliveryId;
	private Integer detailsAmount;

}

