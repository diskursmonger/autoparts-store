package ru.nsu.ccfit.kozlova.autoparts.backend.model.queries.seven.four;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
@NoArgsConstructor
public class SevenFourQueryParams {

	private LocalDate minSaleDate;
	private LocalDate maxSaleDate;

}

