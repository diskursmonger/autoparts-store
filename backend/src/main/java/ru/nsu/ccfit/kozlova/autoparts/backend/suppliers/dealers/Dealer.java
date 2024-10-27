package ru.nsu.ccfit.kozlova.autoparts.backend.suppliers.dealers;

import lombok.*;
import lombok.experimental.SuperBuilder;
import ru.nsu.ccfit.kozlova.autoparts.backend.suppliers.Supplier;

import javax.persistence.*;

@Entity
@Table(name = "dealers")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Dealer extends Supplier {

    @Column(name = "website")
    private String website;

}
