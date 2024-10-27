package ru.nsu.ccfit.kozlova.autoparts.backend.sales.orders;

import lombok.*;
import lombok.experimental.SuperBuilder;
import ru.nsu.ccfit.kozlova.autoparts.backend.details.types.DetailType;

import javax.persistence.*;
import java.io.*;

@Entity
@Table(name = "orders_detail_types")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class OrderDetailTypeAmount {

    @Embeddable
    @EqualsAndHashCode
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class OrderDetailTypeAmountId implements Serializable {

        @Column(name = "order_id")
        Long orderId;

        @Column(name = "detail_type_id")
        Long detailTypeId;

    }

    @EmbeddedId
    private OrderDetailTypeAmountId id;

    @ManyToOne
    @MapsId("orderId")
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @MapsId("detailTypeId")
    @JoinColumn(name = "detail_type_id")
    private DetailType detailType;

    @Column(name = "amount")
    private Integer amount;

}
