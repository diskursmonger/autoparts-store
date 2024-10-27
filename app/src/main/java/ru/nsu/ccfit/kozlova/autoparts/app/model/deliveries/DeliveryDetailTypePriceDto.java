package ru.nsu.ccfit.kozlova.autoparts.app.model.deliveries;

import lombok.*;
import lombok.experimental.SuperBuilder;
import ru.nsu.ccfit.kozlova.autoparts.app.model.details.types.DetailTypeDto;

@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class DeliveryDetailTypePriceDto implements Cloneable {

    private DetailTypeDto detailType;

    private Double price;

    @SneakyThrows
    public DeliveryDetailTypePriceDto clone() {
        DeliveryDetailTypePriceDto clone = (DeliveryDetailTypePriceDto) super.clone();
        clone.setDetailType(detailType.clone());
        clone.setPrice(price);
        return clone;
    }

}
