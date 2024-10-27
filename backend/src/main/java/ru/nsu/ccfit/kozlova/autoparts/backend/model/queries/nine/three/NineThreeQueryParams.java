package ru.nsu.ccfit.kozlova.autoparts.backend.model.queries.nine.three;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
@NoArgsConstructor
public class NineThreeQueryParams {

	private LocalDate minDeliveryDate;
	private LocalDate maxDeliveryDate;

}

