package ru.nsu.ccfit.kozlova.autoparts.backend.deliveries;

import lombok.*;
import ru.nsu.ccfit.kozlova.autoparts.backend.details.types.DetailType;

import javax.persistence.*;
import java.io.*;

@Entity
@Table(name = "deliveries_detail_types")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DeliveryDetailTypePrice {

    @Embeddable
    @EqualsAndHashCode
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class DeliveryDetailPriceId implements Serializable {

        @Column(name = "delivery_id")
        Long deliveryId;

        @Column(name = "detail_type_id")
        Long detailTypeId;

    }

    @EmbeddedId
    private DeliveryDetailPriceId id;

    @ManyToOne
    @MapsId("deliveryId")
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;

    @ManyToOne
    @MapsId("detailTypeId")
    @JoinColumn(name = "detail_type_id")
    private DetailType detailType;

    @Column(name = "supplier_price")
    private Double supplierPrice;

}
