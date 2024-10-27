package ru.nsu.ccfit.kozlova.autoparts.backend.model.suppliers.guarantees;

import lombok.*;
import lombok.experimental.SuperBuilder;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.AbstractDto;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.details.types.DetailTypeDto;

@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class GuaranteeDto extends AbstractDto<Long> {

	private Long supplierId;

	private DetailTypeDto detailType;

	private Integer guaranteeMonths;

}
