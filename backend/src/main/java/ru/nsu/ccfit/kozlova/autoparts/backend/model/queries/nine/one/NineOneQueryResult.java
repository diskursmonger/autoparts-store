package ru.nsu.ccfit.kozlova.autoparts.backend.model.queries.nine.one;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
@NoArgsConstructor
public class NineOneQueryResult {

	private Long id;
	private Long detailTypeId;
	private LocalDate deliveryDate;
	private LocalDate saleDate;

}

