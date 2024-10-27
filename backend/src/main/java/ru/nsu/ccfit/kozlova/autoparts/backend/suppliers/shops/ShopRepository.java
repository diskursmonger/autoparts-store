package ru.nsu.ccfit.kozlova.autoparts.backend.suppliers.shops;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.nsu.ccfit.kozlova.autoparts.backend.suppliers.firms.Firm;

@Repository
public interface ShopRepository extends JpaRepository<Shop, Long> {
}
