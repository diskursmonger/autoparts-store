package ru.nsu.ccfit.kozlova.autoparts.app.model.suppliers.smallsuppliers;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class SmallSupplierCreateRequest {

	private String name;

	private String phoneNumber;

}
