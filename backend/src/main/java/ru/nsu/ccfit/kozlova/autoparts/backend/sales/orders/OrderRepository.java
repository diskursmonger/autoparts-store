package ru.nsu.ccfit.kozlova.autoparts.backend.sales.orders;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.nsu.ccfit.kozlova.autoparts.backend.suppliers.shops.Shop;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
