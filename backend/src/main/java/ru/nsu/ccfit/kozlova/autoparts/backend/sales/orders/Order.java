package ru.nsu.ccfit.kozlova.autoparts.backend.sales.orders;

import lombok.*;
import lombok.experimental.SuperBuilder;
import ru.nsu.ccfit.kozlova.autoparts.backend.AbstractEntity;
import ru.nsu.ccfit.kozlova.autoparts.backend.sales.customers.Customer;

import javax.persistence.*;
import java.time.*;
import java.util.*;

@Entity
@Table(name = "orders")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Order extends AbstractEntity<Long> {

    @Column(name = "order_date")
    private LocalDate orderDate;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToMany(mappedBy = "order", fetch = FetchType.EAGER, orphanRemoval = true)
    private final Set<OrderDetailTypeAmount> orderDetailTypeAmounts = new HashSet<>();

}
