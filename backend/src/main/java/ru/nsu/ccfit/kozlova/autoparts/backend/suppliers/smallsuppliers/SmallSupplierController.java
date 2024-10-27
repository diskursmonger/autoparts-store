package ru.nsu.ccfit.kozlova.autoparts.backend.suppliers.smallsuppliers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.suppliers.smallsuppliers.SmallSupplierCreateRequest;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.suppliers.smallsuppliers.SmallSupplierDto;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.suppliers.smallsuppliers.SmallSupplierUpdateRequest;
import ru.nsu.ccfit.kozlova.autoparts.backend.crud.controller.AbstractCrudController;

@RestController
@RequestMapping("/small-suppliers")
public class SmallSupplierController extends AbstractCrudController<
		SmallSupplierDto, SmallSupplierCreateRequest, SmallSupplierUpdateRequest, Long> {

	private final SmallSupplierService smallSupplierService;

	public SmallSupplierController(SmallSupplierService smallSupplierService) {
		super(smallSupplierService);
		this.smallSupplierService = smallSupplierService;
	}
}
