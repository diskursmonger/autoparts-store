package ru.nsu.ccfit.kozlova.autoparts.backend.suppliers.firms;

import org.springframework.stereotype.Service;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.suppliers.firms.FirmCreateRequest;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.suppliers.firms.FirmDto;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.suppliers.firms.FirmUpdateRequest;
import ru.nsu.ccfit.kozlova.autoparts.backend.crud.service.AbstractCrudService;

@Service
public class FirmService extends AbstractCrudService<
		Firm, FirmDto, FirmCreateRequest, FirmUpdateRequest, Long> {

	private final FirmRepository firmRepository;
	private final FirmMapper firmMapper;


	public FirmService(
			FirmRepository firmRepository,
			FirmMapper firmMapper
	) {
		super(firmRepository, firmMapper);
		this.firmRepository = firmRepository;
		this.firmMapper = firmMapper;
	}
}
