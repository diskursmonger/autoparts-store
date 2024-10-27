package ru.nsu.ccfit.kozlova.autoparts.backend.model.deliveries;

import lombok.*;
import lombok.experimental.*;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.details.types.*;

@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class DeliveryDetailTypePriceDto {

    private DetailTypeDto detailType;

    private Double price;

}
