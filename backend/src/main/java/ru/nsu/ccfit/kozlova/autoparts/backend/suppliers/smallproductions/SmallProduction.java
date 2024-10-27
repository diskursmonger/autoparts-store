package ru.nsu.ccfit.kozlova.autoparts.backend.suppliers.smallproductions;

import lombok.*;
import lombok.experimental.SuperBuilder;
import ru.nsu.ccfit.kozlova.autoparts.backend.suppliers.Supplier;

import javax.persistence.*;

@Entity
@Table(name = "small_productions")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class SmallProduction extends Supplier {

    @Column(name = "website")
    private String website;

}