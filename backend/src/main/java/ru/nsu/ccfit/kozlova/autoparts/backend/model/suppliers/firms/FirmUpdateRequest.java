package ru.nsu.ccfit.kozlova.autoparts.backend.model.suppliers.firms;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class FirmUpdateRequest {

	private String name;

	private String website;

}
