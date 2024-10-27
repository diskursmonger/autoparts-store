package ru.nsu.ccfit.kozlova.autoparts.app.model.sales.orders;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.Date;

@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class OrderUpdateRequest {

	private Date orderDate;

	private Long customerId;

}
