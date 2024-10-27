package ru.nsu.ccfit.kozlova.autoparts.backend.model.queries.twelve.one;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
@NoArgsConstructor
public class TwelveOneQueryParams {

	private LocalDate minSaleDate;
	private LocalDate maxSaleDate;

}
