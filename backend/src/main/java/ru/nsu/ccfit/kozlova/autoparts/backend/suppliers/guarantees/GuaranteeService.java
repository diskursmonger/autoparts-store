package ru.nsu.ccfit.kozlova.autoparts.backend.suppliers.guarantees;

import org.springframework.stereotype.Service;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.suppliers.guarantees.GuaranteeCreateRequest;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.suppliers.guarantees.GuaranteeDto;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.suppliers.guarantees.GuaranteeUpdateRequest;
import ru.nsu.ccfit.kozlova.autoparts.backend.crud.service.AbstractCrudService;

@Service
public class GuaranteeService extends AbstractCrudService<
		Guarantee, GuaranteeDto, GuaranteeCreateRequest, GuaranteeUpdateRequest, Long> {

	private final GuaranteeRepository guaranteeRepository;
	private final GuaranteeMapper guaranteeMapper;

	public GuaranteeService(
			GuaranteeRepository guaranteeRepository,
			GuaranteeMapper guaranteeMapper
	) {
		super(guaranteeRepository, guaranteeMapper);
		this.guaranteeRepository = guaranteeRepository;
		this.guaranteeMapper = guaranteeMapper;
	}
}
