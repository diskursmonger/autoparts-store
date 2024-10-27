package ru.nsu.ccfit.kozlova.autoparts.backend.suppliers.firms;

import lombok.*;
import lombok.experimental.SuperBuilder;
import ru.nsu.ccfit.kozlova.autoparts.backend.suppliers.Supplier;

import javax.persistence.*;

@Entity
@Table(name = "firms")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Firm extends Supplier {

    @Column(name = "website")
    private String website;

}
