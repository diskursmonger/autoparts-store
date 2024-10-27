package ru.nsu.ccfit.kozlova.autoparts.app.model.queries.seven.four;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Getter @Setter
@NoArgsConstructor
public class SevenFourQueryParams {

	private Date minSaleDate;
	private Date maxSaleDate;

}

