package ru.nsu.ccfit.kozlova.autoparts.backend.model.sales;

import lombok.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class SaleUpdateRequest {

	private LocalDate saleDate;

	private Long customerId;

	private Long orderId;

}
