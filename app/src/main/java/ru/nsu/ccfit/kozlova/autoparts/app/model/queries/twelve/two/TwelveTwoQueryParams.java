package ru.nsu.ccfit.kozlova.autoparts.app.model.queries.twelve.two;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Getter @Setter
@NoArgsConstructor
public class TwelveTwoQueryParams {

	private Date minCustomerRefDate;
	private Date maxCustomerRefDate;

}

