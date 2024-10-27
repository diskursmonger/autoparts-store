package ru.nsu.ccfit.kozlova.autoparts.backend.suppliers.dealers;

import org.springframework.stereotype.Service;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.suppliers.dealers.DealerCreateRequest;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.suppliers.dealers.DealerDto;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.suppliers.dealers.DealerUpdateRequest;
import ru.nsu.ccfit.kozlova.autoparts.backend.crud.service.AbstractCrudService;

@Service
public class DealerService extends AbstractCrudService<
		Dealer, DealerDto, DealerCreateRequest, DealerUpdateRequest, Long> {

	private final DealerRepository dealerRepository;
	private final DealerMapper dealerMapper;


	public DealerService(
			DealerRepository dealerRepository,
			DealerMapper dealerMapper
	) {
		super(dealerRepository, dealerMapper);
		this.dealerRepository = dealerRepository;
		this.dealerMapper = dealerMapper;
	}
}
