package ru.nsu.ccfit.kozlova.autoparts.backend.suppliers.smallsuppliers;

import org.springframework.stereotype.Service;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.suppliers.smallsuppliers.SmallSupplierCreateRequest;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.suppliers.smallsuppliers.SmallSupplierDto;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.suppliers.smallsuppliers.SmallSupplierUpdateRequest;
import ru.nsu.ccfit.kozlova.autoparts.backend.crud.service.AbstractCrudService;

@Service
public class SmallSupplierService extends AbstractCrudService<
		SmallSupplier, SmallSupplierDto, SmallSupplierCreateRequest, SmallSupplierUpdateRequest, Long> {

	private final SmallSupplierRepository smallSupplierRepository;
	private final SmallSupplierMapper smallSupplierMapper;

	protected SmallSupplierService(
			SmallSupplierRepository smallSupplierRepository,
			SmallSupplierMapper smallSupplierMapper
	) {
		super(smallSupplierRepository, smallSupplierMapper);

		this.smallSupplierMapper = smallSupplierMapper;
		this.smallSupplierRepository = smallSupplierRepository;
	}
}
