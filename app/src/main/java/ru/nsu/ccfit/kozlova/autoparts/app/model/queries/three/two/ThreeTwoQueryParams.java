package ru.nsu.ccfit.kozlova.autoparts.app.model.queries.three.two;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Getter @Setter
@NoArgsConstructor
public class ThreeTwoQueryParams {

	private Long detailTypeId;
	private Date minSaleDate;
	private Date maxSaleDate;

}
