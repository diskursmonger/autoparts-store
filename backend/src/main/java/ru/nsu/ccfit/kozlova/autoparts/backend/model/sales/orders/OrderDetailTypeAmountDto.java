package ru.nsu.ccfit.kozlova.autoparts.backend.model.sales.orders;

import lombok.*;
import lombok.experimental.*;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.details.types.*;

@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class OrderDetailTypeAmountDto {

    private DetailTypeDto detailType;

    private Integer amount;

}
