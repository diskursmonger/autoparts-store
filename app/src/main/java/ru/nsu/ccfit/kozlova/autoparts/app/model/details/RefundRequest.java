package ru.nsu.ccfit.kozlova.autoparts.app.model.details;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.Date;

@SuperBuilder
@AllArgsConstructor
@Getter @Setter
public class RefundRequest {

	private Long detailId;

	private Date customerRefundDate;

	private Date supplierRefundDate;

	public RefundRequest() {

	}
}
