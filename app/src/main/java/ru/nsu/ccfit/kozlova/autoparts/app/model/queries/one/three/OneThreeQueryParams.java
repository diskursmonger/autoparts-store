package ru.nsu.ccfit.kozlova.autoparts.app.model.queries.one.three;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Getter @Setter
@NoArgsConstructor
public class OneThreeQueryParams {

	private Long detailTypeId;
	private Date minDeliveryDate;
	private Date maxDeliveryDate;
	private Integer detailsAmount;

}
