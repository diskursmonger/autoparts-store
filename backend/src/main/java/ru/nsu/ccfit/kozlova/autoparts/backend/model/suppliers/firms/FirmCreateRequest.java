package ru.nsu.ccfit.kozlova.autoparts.backend.model.suppliers.firms;

import lombok.*;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.suppliers.SupplierDto;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class FirmCreateRequest {

	private String name;

	private String website;

}
