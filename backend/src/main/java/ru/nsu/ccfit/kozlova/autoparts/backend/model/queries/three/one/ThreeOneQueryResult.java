package ru.nsu.ccfit.kozlova.autoparts.backend.model.queries.three.one;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
@NoArgsConstructor
public class ThreeOneQueryResult {

	private Long customerId;

	private String customerName;

	private Long saleId;

	private Long detailId;

	private Long detailTypeId;

	private LocalDate saleDate;

}
