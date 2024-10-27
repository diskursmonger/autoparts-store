package ru.nsu.ccfit.kozlova.autoparts.backend.model.queries.ten.one;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
@NoArgsConstructor
public class TenOneQueryResult {

	private Long detailTypeId;
	private Long amount;
	private LocalDate deliveryDate;
	private LocalDate customerRefundDate;
	private Long supplierId;

}

