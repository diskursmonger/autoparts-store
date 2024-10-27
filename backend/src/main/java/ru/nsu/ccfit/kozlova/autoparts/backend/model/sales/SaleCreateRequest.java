package ru.nsu.ccfit.kozlova.autoparts.backend.model.sales;

import lombok.*;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.details.DetailDto;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.sales.customers.CustomerDto;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.sales.orders.OrderDto;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class SaleCreateRequest {

	private LocalDate saleDate;

	private Long customerId;

	private Long orderId;

}
