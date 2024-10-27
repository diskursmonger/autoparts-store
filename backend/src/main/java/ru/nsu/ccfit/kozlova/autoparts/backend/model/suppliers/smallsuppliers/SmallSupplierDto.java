package ru.nsu.ccfit.kozlova.autoparts.backend.model.suppliers.smallsuppliers;

import lombok.*;
import lombok.experimental.SuperBuilder;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.suppliers.SupplierDto;

@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class SmallSupplierDto extends SupplierDto {

	private String phoneNumber;

}
