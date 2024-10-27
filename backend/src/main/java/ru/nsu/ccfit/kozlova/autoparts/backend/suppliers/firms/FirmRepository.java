package ru.nsu.ccfit.kozlova.autoparts.backend.suppliers.firms;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.nsu.ccfit.kozlova.autoparts.backend.suppliers.dealers.Dealer;

@Repository
public interface FirmRepository extends JpaRepository<Firm, Long> {
}
