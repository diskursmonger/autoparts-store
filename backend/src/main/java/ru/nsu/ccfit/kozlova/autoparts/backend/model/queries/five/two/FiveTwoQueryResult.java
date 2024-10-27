package ru.nsu.ccfit.kozlova.autoparts.backend.model.queries.five.two;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class FiveTwoQueryResult {

	private Long suppId;
	private Long detTypeId;
	private Double avgPrice;
	private Long soldDetTAmount;

}

