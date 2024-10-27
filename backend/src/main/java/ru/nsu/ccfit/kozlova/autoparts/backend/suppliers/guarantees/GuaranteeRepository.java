package ru.nsu.ccfit.kozlova.autoparts.backend.suppliers.guarantees;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.nsu.ccfit.kozlova.autoparts.backend.suppliers.Supplier;

@Repository
public interface GuaranteeRepository extends JpaRepository<Guarantee, Long> {

	Page<Guarantee> getAllBySupplierId(Long supplierId, Pageable pageable);

}
