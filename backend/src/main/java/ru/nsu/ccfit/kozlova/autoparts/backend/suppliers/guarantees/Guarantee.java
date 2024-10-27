package ru.nsu.ccfit.kozlova.autoparts.backend.suppliers.guarantees;

import lombok.*;
import lombok.experimental.SuperBuilder;
import ru.nsu.ccfit.kozlova.autoparts.backend.AbstractEntity;
import ru.nsu.ccfit.kozlova.autoparts.backend.details.types.DetailType;
import ru.nsu.ccfit.kozlova.autoparts.backend.suppliers.Supplier;

import javax.persistence.*;

@Entity
@Table(name = "guarantees")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Guarantee extends AbstractEntity<Long> {

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

    @ManyToOne
    @JoinColumn(name = "detail_type_id")
    private DetailType detailType;

    @Column(name = "guarantee_months")
    private Integer guaranteeMonths;

}
