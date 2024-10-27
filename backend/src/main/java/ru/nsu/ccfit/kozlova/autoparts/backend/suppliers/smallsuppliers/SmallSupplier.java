package ru.nsu.ccfit.kozlova.autoparts.backend.suppliers.smallsuppliers;

import lombok.*;
import lombok.experimental.SuperBuilder;
import ru.nsu.ccfit.kozlova.autoparts.backend.suppliers.Supplier;

import javax.persistence.*;

@Entity
@Table(name = "small_suppliers")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class SmallSupplier extends Supplier {

    @Column(name = "phone_number")
    private String phoneNumber;

}
