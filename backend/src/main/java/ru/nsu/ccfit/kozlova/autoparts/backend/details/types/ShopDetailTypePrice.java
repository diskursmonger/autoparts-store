package ru.nsu.ccfit.kozlova.autoparts.backend.details.types;

import lombok.*;
import lombok.experimental.SuperBuilder;
import ru.nsu.ccfit.kozlova.autoparts.backend.details.types.DetailType;

import javax.persistence.*;

@Entity
@Table(name = "details_shop_prices")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class ShopDetailTypePrice {

    @Id
    @Column(name = "detail_type_id")
    private Long id;

    @Column(name = "shop_price")
    private Double shopPrice;

    @OneToOne
    @MapsId
    @JoinColumn(name = "detail_type_id")
    private DetailType detailType;

}
