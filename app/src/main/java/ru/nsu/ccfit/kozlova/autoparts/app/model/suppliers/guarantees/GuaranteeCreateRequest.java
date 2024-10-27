package ru.nsu.ccfit.kozlova.autoparts.app.model.suppliers.guarantees;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class GuaranteeCreateRequest {

	private Long supplierId;

	private Long detailTypeId;

	private Integer guaranteeMonths;

}
