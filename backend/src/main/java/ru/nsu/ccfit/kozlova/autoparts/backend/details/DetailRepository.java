package ru.nsu.ccfit.kozlova.autoparts.backend.details;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.nsu.ccfit.kozlova.autoparts.backend.sales.Sale;

@Repository
public interface DetailRepository extends JpaRepository<Detail, Long> {
}
