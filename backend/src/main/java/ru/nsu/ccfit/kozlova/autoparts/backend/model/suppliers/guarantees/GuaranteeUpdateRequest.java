package ru.nsu.ccfit.kozlova.autoparts.backend.model.suppliers.guarantees;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class GuaranteeUpdateRequest {

	private Long detailTypeId;

	private Integer guaranteeMonths;

}
