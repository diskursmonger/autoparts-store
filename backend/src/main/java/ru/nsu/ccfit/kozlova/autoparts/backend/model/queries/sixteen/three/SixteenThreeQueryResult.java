package ru.nsu.ccfit.kozlova.autoparts.backend.model.queries.sixteen.three;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class SixteenThreeQueryResult {

	private Integer amount;
	private Long detTypeId;
	private Long orderId;
	private Double sumShopPrice;

}

