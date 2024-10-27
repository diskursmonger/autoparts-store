package ru.nsu.ccfit.kozlova.autoparts.backend.details;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.time.*;

@Entity
@Table(name = "refunds")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Refund {

    @Id
    @Column(name = "detail_id")
    private Long id;

    @Column(name = "customer_refund_date")
    private LocalDate customerRefundDate;

    @Column(name = "supplier_refund_date")
    private LocalDate supplierRefundDate;

    @OneToOne
    @MapsId
    @JoinColumn(name = "detail_id")
    private Detail detail;

}
