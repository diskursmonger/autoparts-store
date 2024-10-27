package ru.nsu.ccfit.kozlova.autoparts.backend.model.sales.orders;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.AbstractDto;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class OrderUpdateRequest {

	private LocalDate orderDate;

	private Long customerId;

}
