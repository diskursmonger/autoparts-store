package ru.nsu.ccfit.kozlova.autoparts.backend.suppliers;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.suppliers.SupplierDto;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.suppliers.guarantees.GuaranteeDto;
import ru.nsu.ccfit.kozlova.autoparts.backend.suppliers.guarantees.GuaranteeMapper;
import ru.nsu.ccfit.kozlova.autoparts.backend.suppliers.guarantees.GuaranteeRepository;

import java.util.stream.Collectors;

@Service
@Transactional
public class SupplierService {

	private final SupplierRepository supplierRepository;

	private final GuaranteeRepository guaranteeRepository;
	private final GuaranteeMapper guaranteeMapper;

	public SupplierService(
			SupplierRepository supplierRepository,
			GuaranteeRepository guaranteeRepository,
			GuaranteeMapper guaranteeMapper
	) {
		this.supplierRepository = supplierRepository;
		this.guaranteeRepository = guaranteeRepository;
		this.guaranteeMapper = guaranteeMapper;
	}

	public Page<GuaranteeDto> getSupplierGuarantees(Long supplierId, Pageable pageable) {
		return guaranteeRepository.getAllBySupplierId(supplierId, pageable).map(guaranteeMapper::toDto);
	}

	public Page<SupplierDto> getAll(Pageable pageable) {
		return supplierRepository.findAll(pageable).map(s -> {
			var guarantees = s.getGuarantees()
					.stream()
					.map(guaranteeMapper::toDto)
					.collect(Collectors.toSet());

			return SupplierDto.builder()
					.id(s.getId())
					.name(s.getName())
					.guarantees(guarantees)
					.build();
		});

	}
}
