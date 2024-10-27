package ru.nsu.ccfit.kozlova.autoparts.app.model.queries.twelve.one;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Getter @Setter
@NoArgsConstructor
public class TwelveOneQueryParams {

	private Date minSaleDate;
	private Date maxSaleDate;

}
