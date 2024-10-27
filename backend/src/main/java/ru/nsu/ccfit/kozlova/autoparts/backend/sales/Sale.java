package ru.nsu.ccfit.kozlova.autoparts.backend.sales;

import lombok.*;
import lombok.experimental.SuperBuilder;
import ru.nsu.ccfit.kozlova.autoparts.backend.AbstractEntity;
import ru.nsu.ccfit.kozlova.autoparts.backend.details.Detail;
import ru.nsu.ccfit.kozlova.autoparts.backend.sales.customers.Customer;
import ru.nsu.ccfit.kozlova.autoparts.backend.sales.orders.Order;

import javax.persistence.*;
import java.time.*;
import java.util.*;

@Entity
@Table(name = "sales")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Sale extends AbstractEntity<Long> {

    @Column(name = "sale_date")
    private LocalDate saleDate;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToMany(
        cascade = {CascadeType.PERSIST, CascadeType.MERGE},
        fetch = FetchType.EAGER
    )
    @JoinTable(
            name = "sold_details",
            joinColumns = @JoinColumn(name = "sale_id"),
            inverseJoinColumns = @JoinColumn(name = "detail_id")
    )
    private final Set<Detail> details = new HashSet<>();

}
