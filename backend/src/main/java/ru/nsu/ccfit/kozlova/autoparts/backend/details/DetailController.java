package ru.nsu.ccfit.kozlova.autoparts.backend.details;

import org.springframework.web.bind.annotation.*;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.details.*;
import ru.nsu.ccfit.kozlova.autoparts.backend.crud.controller.AbstractCrudController;

@RestController
@RequestMapping("/details")
public class DetailController extends AbstractCrudController<
		DetailDto, DetailCreateRequest, DetailUpdateRequest, Long> {

	private final DetailService detailService;

	public DetailController(DetailService detailService) {
		super(detailService);
		this.detailService = detailService;
	}

	@PutMapping("/{detailId}/refund")
	public RefundDto makeRefund(
			@PathVariable Long detailId,
			@RequestBody RefundRequest refundRequest
	) {
		return detailService.makeRefund(detailId, refundRequest);
	}
}
