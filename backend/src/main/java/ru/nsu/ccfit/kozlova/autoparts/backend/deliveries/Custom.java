package ru.nsu.ccfit.kozlova.autoparts.backend.deliveries;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.time.*;

@Entity
@Table(name = "customs")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Custom {

    @Id
    @Column(name = "delivery_id")
    private Long id;

    @Column(name = "clearance_date")
    private LocalDate clearanceDate;

    @Column(name = "tax_percent")
    private Double taxPercent;

    @OneToOne
    @MapsId
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;

}
