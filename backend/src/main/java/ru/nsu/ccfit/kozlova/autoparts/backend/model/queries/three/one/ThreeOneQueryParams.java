package ru.nsu.ccfit.kozlova.autoparts.backend.model.queries.three.one;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
@NoArgsConstructor
public class ThreeOneQueryParams {

	private Long detailTypeId;

	private LocalDate minSaleDate;

	private LocalDate maxSaleDate;

}
