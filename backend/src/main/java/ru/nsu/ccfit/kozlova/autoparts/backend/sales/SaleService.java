package ru.nsu.ccfit.kozlova.autoparts.backend.sales;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.details.DetailDto;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.sales.SaleCreateRequest;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.sales.SaleDto;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.sales.SaleUpdateRequest;
import ru.nsu.ccfit.kozlova.autoparts.backend.crud.service.AbstractCrudService;
import ru.nsu.ccfit.kozlova.autoparts.backend.details.Detail;
import ru.nsu.ccfit.kozlova.autoparts.backend.details.DetailRepository;

@Service
@Transactional
public class SaleService extends AbstractCrudService<
		Sale, SaleDto, SaleCreateRequest, SaleUpdateRequest, Long> {

	private final SaleRepository saleRepository;
	private final SaleMapper saleMapper;
	private final DetailRepository detailRepository;

	public SaleService(
			SaleRepository saleRepository,
			SaleMapper saleMapper,
			DetailRepository detailRepository
	) {
		super(saleRepository, saleMapper);
		this.saleRepository = saleRepository;
		this.saleMapper = saleMapper;
		this.detailRepository = detailRepository;
	}

	public SaleDto addDetail(Long saleId, Long detailId) {
		Sale sale = getEntityByIdOrThrow(saleId);
		Detail detail = getEntityByIdOrThrow(detailRepository, detailId);

		sale.getDetails().removeIf(d -> d.getId().equals(detailId));
		sale.getDetails().add(detail);

		return saleMapper.toDto(sale);
	}

	public void deleteDetail(Long saleId, Long detailId) {
		Sale sale = getEntityByIdOrThrow(saleId);
		sale.getDetails().removeIf(d -> d.getId().equals(detailId));
	}
}
