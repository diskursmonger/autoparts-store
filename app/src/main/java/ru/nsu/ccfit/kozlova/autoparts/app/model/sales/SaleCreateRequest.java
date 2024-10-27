package ru.nsu.ccfit.kozlova.autoparts.app.model.sales;

import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class SaleCreateRequest {

	private Date saleDate;

	private Long customerId;

	private Long orderId;

}
