package ru.nsu.ccfit.kozlova.autoparts.backend.suppliers;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.suppliers.SupplierDto;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.suppliers.guarantees.GuaranteeDto;

@RestController
@RequestMapping("/suppliers")
public class SupplierController {

	private final SupplierService supplierService;

	public SupplierController(SupplierService supplierService) {
		this.supplierService = supplierService;
	}

	@GetMapping("/{supplierId}/guarantees")
	public Page<GuaranteeDto> getSupplierGuarantees(@PathVariable Long supplierId, Pageable pageable) {
		return supplierService.getSupplierGuarantees(supplierId, pageable);
	}

	@GetMapping
	public Page<SupplierDto> getAll(Pageable pageable) {
		return supplierService.getAll(pageable);
	}

}
