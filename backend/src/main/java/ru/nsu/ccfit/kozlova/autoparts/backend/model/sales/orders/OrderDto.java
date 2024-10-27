package ru.nsu.ccfit.kozlova.autoparts.backend.model.sales.orders;

import lombok.*;
import lombok.experimental.SuperBuilder;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.AbstractDto;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.sales.customers.CustomerDto;

import java.time.LocalDate;
import java.util.Set;

@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class OrderDto extends AbstractDto<Long> {

	private LocalDate orderDate;

	private CustomerDto customer;

	private Set<OrderDetailTypeAmountDto> detailTypeAmounts;

}
