package ru.nsu.ccfit.kozlova.autoparts.backend.model.queries.ten.two;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
@NoArgsConstructor
public class TenTwoQueryParams {

	private LocalDate minDeliveryDate;
	private LocalDate maxDeliveryDate;

}

