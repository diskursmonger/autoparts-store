package ru.nsu.ccfit.kozlova.autoparts.backend.model.suppliers.dealers;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class DealerUpdateRequest {

	private String name;

	private String website;

}
