package ru.nsu.ccfit.kozlova.autoparts.backend.model.suppliers.shops;

import lombok.*;
import lombok.experimental.SuperBuilder;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.suppliers.SupplierDto;

@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class ShopDto extends SupplierDto {

	private String address;

}
