package ru.nsu.ccfit.kozlova.autoparts.backend.model.queries.thirteen;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class ThirteenQueryResult {

	private Long detailTypeId;
	private String name;
	private Long detailTypesAmount;
	private Double shopPrice;

}

