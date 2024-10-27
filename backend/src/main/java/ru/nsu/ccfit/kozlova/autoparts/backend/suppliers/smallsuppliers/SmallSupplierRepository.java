package ru.nsu.ccfit.kozlova.autoparts.backend.suppliers.smallsuppliers;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SmallSupplierRepository extends JpaRepository<SmallSupplier, Long> {
}
