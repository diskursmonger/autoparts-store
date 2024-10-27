package ru.nsu.ccfit.kozlova.autoparts.backend.model.queries.one.three;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
@NoArgsConstructor
public class OneThreeQueryParams {

	private Long detailTypeId;
	private LocalDate minDeliveryDate;
	private LocalDate maxDeliveryDate;
	private Integer detailsAmount;

}
