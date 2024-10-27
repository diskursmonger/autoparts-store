package ru.nsu.ccfit.kozlova.autoparts.backend.model.suppliers;

import lombok.*;
import lombok.experimental.SuperBuilder;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.AbstractDto;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.suppliers.guarantees.GuaranteeDto;

import java.util.Set;

@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class SupplierDto extends AbstractDto<Long> {

	private String name;

	private Set<GuaranteeDto> guarantees;

}
