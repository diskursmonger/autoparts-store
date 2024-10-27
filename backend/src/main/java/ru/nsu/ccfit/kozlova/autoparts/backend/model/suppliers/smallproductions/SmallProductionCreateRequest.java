package ru.nsu.ccfit.kozlova.autoparts.backend.model.suppliers.smallproductions;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class SmallProductionCreateRequest {

	private String name;

	private String website;

}
