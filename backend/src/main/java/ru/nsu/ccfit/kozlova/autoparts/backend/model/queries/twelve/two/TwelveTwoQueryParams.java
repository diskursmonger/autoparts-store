package ru.nsu.ccfit.kozlova.autoparts.backend.model.queries.twelve.two;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
@NoArgsConstructor
public class TwelveTwoQueryParams {

	private LocalDate minCustomerRefDate;
	private LocalDate maxCustomerRefDate;

}

