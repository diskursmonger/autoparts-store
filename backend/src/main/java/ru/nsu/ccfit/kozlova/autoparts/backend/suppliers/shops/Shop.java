package ru.nsu.ccfit.kozlova.autoparts.backend.suppliers.shops;

import lombok.*;
import lombok.experimental.SuperBuilder;
import ru.nsu.ccfit.kozlova.autoparts.backend.suppliers.Supplier;

import javax.persistence.*;

@Entity
@Table(name = "shops")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Shop extends Supplier {

    @Column(name = "address")
    private String address;

}
