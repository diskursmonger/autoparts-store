package ru.nsu.ccfit.kozlova.autoparts.backend.model.queries.ten.one;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
@NoArgsConstructor
public class TenOneQueryParams {

	private LocalDate minDeliveryDate;
	private LocalDate maxDeliveryDate;

}

