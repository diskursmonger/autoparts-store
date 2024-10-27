package ru.nsu.ccfit.kozlova.autoparts.app.model.queries.nine.three;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Getter @Setter
@NoArgsConstructor
public class NineThreeQueryParams {

	private Date minDeliveryDate;
	private Date maxDeliveryDate;

}

