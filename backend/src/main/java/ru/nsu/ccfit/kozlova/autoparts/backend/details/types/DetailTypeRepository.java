package ru.nsu.ccfit.kozlova.autoparts.backend.details.types;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.nsu.ccfit.kozlova.autoparts.backend.sales.Sale;

@Repository
public interface DetailTypeRepository extends JpaRepository<DetailType, Long> {
}
