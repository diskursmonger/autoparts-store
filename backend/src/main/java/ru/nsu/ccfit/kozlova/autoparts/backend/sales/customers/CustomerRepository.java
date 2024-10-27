package ru.nsu.ccfit.kozlova.autoparts.backend.sales.customers;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.nsu.ccfit.kozlova.autoparts.backend.sales.Sale;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
