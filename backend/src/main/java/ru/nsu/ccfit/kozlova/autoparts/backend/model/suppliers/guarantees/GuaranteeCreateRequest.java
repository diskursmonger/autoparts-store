package ru.nsu.ccfit.kozlova.autoparts.backend.model.suppliers.guarantees;

import lombok.*;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.AbstractDto;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.details.types.DetailTypeDto;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class GuaranteeCreateRequest {

	private Long supplierId;

	private Long detailTypeId;

	private Integer guaranteeMonths;

}
