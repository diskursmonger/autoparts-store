package ru.nsu.ccfit.kozlova.autoparts.app.model.queries.nine.two;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Getter @Setter
@NoArgsConstructor
public class NineTwoQueryParams {

	private Date minDeliveryDate;
	private Date maxDeliveryDate;

}

