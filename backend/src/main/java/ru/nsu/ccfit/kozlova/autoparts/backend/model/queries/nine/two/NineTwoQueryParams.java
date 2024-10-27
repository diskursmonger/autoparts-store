package ru.nsu.ccfit.kozlova.autoparts.backend.model.queries.nine.two;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
@NoArgsConstructor
public class NineTwoQueryParams {

	private LocalDate minDeliveryDate;
	private LocalDate maxDeliveryDate;

}

