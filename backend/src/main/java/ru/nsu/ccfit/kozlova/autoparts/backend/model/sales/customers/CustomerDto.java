package ru.nsu.ccfit.kozlova.autoparts.backend.model.sales.customers;

import lombok.*;
import lombok.experimental.SuperBuilder;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.AbstractDto;

@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class CustomerDto extends AbstractDto<Long> {

	private String name;

}
