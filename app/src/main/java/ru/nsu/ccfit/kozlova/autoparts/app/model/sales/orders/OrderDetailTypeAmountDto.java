package ru.nsu.ccfit.kozlova.autoparts.app.model.sales.orders;

import lombok.*;
import lombok.experimental.SuperBuilder;
import ru.nsu.ccfit.kozlova.autoparts.app.model.details.types.DetailTypeDto;

@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class OrderDetailTypeAmountDto implements Cloneable {

    private DetailTypeDto detailType;

    private Integer amount;

    @SneakyThrows
    public OrderDetailTypeAmountDto clone() {
        OrderDetailTypeAmountDto clone = (OrderDetailTypeAmountDto) super.clone();
        clone.setAmount(amount);
        clone.setDetailType(detailType.clone());
        return clone;
    }

}
