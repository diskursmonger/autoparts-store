package ru.nsu.ccfit.kozlova.autoparts.backend.model.sales;

import lombok.*;
import lombok.experimental.SuperBuilder;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.AbstractDto;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.details.DetailDto;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.sales.customers.CustomerDto;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.sales.orders.OrderDto;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class SaleDto extends AbstractDto<Long> {

	private LocalDate saleDate;

	private CustomerDto customer;

	private OrderDto order;

	private Set<DetailDto> details;
	
}
