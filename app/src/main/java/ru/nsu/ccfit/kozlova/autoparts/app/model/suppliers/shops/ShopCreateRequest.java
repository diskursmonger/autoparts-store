package ru.nsu.ccfit.kozlova.autoparts.app.model.suppliers.shops;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class ShopCreateRequest {

	private String name;

	private String address;

}
