package ru.nsu.ccfit.kozlova.autoparts.backend.deliveries;

import lombok.*;
import lombok.experimental.SuperBuilder;
import ru.nsu.ccfit.kozlova.autoparts.backend.AbstractEntity;
import ru.nsu.ccfit.kozlova.autoparts.backend.details.Detail;
import ru.nsu.ccfit.kozlova.autoparts.backend.suppliers.Supplier;

import javax.persistence.*;
import java.time.*;
import java.util.*;

@Entity
@Table(name = "deliveries")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Delivery extends AbstractEntity<Long> {

    @Column(name = "discount_percent")
    private Double discountPercent;

    @Column(name = "formation_date")
    private LocalDate formationDate;

    @Column(name = "delivery_date")
    private LocalDate deliveryDate;

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

    @OneToOne(
        mappedBy = "delivery",
        cascade = CascadeType.ALL
    )
    @PrimaryKeyJoinColumn
    private Custom custom;

    @OneToMany(
        mappedBy = "delivery",
        cascade = CascadeType.ALL,
        fetch = FetchType.EAGER
    )
    private final Set<Detail> details = new HashSet<>();

    @OneToMany(mappedBy = "delivery", fetch = FetchType.EAGER)
    private final Set<DeliveryDetailTypePrice> deliveryDetailTypePrices = new HashSet<>();

}
