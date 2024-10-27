package ru.nsu.ccfit.kozlova.autoparts.backend.sales.customers;

import lombok.*;
import lombok.experimental.SuperBuilder;
import ru.nsu.ccfit.kozlova.autoparts.backend.AbstractEntity;
import ru.nsu.ccfit.kozlova.autoparts.backend.sales.orders.Order;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "customers")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Customer extends AbstractEntity<Long> {

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "customer")
    private final Set<Order> orders = new HashSet<>();

}
