package ru.nsu.ccfit.kozlova.autoparts.backend.suppliers.smallproductions;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.nsu.ccfit.kozlova.autoparts.backend.suppliers.firms.Firm;

@Repository
public interface SmallProductionRepository extends JpaRepository<SmallProduction, Long> {
}
