package ru.nsu.ccfit.kozlova.autoparts.backend.deliveries;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.nsu.ccfit.kozlova.autoparts.backend.sales.Sale;

@Repository
public interface DeliveryRepository extends JpaRepository<Delivery, Long> {
}
