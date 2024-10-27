package ru.nsu.ccfit.kozlova.autoparts.app.model.suppliers.firms;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class FirmCreateRequest {

	private String name;

	private String website;

}
