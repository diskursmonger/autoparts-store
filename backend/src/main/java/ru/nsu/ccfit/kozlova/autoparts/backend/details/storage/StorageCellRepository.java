package ru.nsu.ccfit.kozlova.autoparts.backend.details.storage;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.nsu.ccfit.kozlova.autoparts.backend.sales.Sale;

@Repository
public interface StorageCellRepository extends JpaRepository<StorageCell, Long> {
}
