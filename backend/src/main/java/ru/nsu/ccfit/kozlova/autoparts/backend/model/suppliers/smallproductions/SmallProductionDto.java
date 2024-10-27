package ru.nsu.ccfit.kozlova.autoparts.backend.model.suppliers.smallproductions;

import lombok.*;
import lombok.experimental.SuperBuilder;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.suppliers.SupplierDto;

@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class SmallProductionDto extends SupplierDto {

	private String website;

}
