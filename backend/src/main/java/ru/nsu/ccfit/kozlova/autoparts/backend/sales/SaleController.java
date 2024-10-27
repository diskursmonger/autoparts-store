package ru.nsu.ccfit.kozlova.autoparts.backend.sales;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.details.DetailDto;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.sales.SaleCreateRequest;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.sales.SaleDto;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.sales.SaleUpdateRequest;
import ru.nsu.ccfit.kozlova.autoparts.backend.crud.controller.AbstractCrudController;

@RestController
@RequestMapping("/sales")
public class SaleController extends AbstractCrudController<
		SaleDto, SaleCreateRequest, SaleUpdateRequest, Long> {

	private final SaleService saleService;

	public SaleController(SaleService saleService) {
		super(saleService);
		this.saleService = saleService;
	}

	@PutMapping("/{saleId}/details/{detailId}")
	public SaleDto addDetail(
			@PathVariable Long saleId,
			@PathVariable Long detailId
	) {
		return saleService.addDetail(saleId, detailId);
	}

	@DeleteMapping("/{saleId}/details/{detailId}")
	public void deleteDetail(
			@PathVariable Long saleId,
			@PathVariable Long detailId
	) {
		saleService.deleteDetail(saleId, detailId);
	}

}
