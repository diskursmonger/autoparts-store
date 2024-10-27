package ru.nsu.ccfit.kozlova.autoparts.backend.suppliers;

import lombok.*;
import lombok.experimental.SuperBuilder;
import ru.nsu.ccfit.kozlova.autoparts.backend.AbstractEntity;
import ru.nsu.ccfit.kozlova.autoparts.backend.suppliers.guarantees.Guarantee;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "suppliers")
@Inheritance(strategy = InheritanceType.JOINED)
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Supplier extends AbstractEntity<Long> {

    @Column(name = "name")
    private String name;

    @OneToMany(
        mappedBy = "supplier",
        cascade = CascadeType.ALL,
        fetch = FetchType.EAGER
    )
    private final Set<Guarantee> guarantees = new HashSet<>();

}
