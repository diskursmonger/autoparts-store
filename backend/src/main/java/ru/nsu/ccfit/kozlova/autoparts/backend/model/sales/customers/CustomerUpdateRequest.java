package ru.nsu.ccfit.kozlova.autoparts.backend.model.sales.customers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.AbstractDto;

@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class CustomerUpdateRequest {

	private String name;

}
