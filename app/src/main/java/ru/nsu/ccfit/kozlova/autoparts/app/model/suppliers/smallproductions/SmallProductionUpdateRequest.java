package ru.nsu.ccfit.kozlova.autoparts.app.model.suppliers.smallproductions;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class SmallProductionUpdateRequest {

	private String name;

	private String website;

}
