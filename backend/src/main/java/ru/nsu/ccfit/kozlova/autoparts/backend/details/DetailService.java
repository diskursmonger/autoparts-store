package ru.nsu.ccfit.kozlova.autoparts.backend.details;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.details.*;
import ru.nsu.ccfit.kozlova.autoparts.backend.crud.service.AbstractCrudService;

@Service
@Transactional
public class DetailService extends AbstractCrudService<
		Detail, DetailDto, DetailCreateRequest, DetailUpdateRequest, Long> {

	private final DetailRepository detailRepository;
	private final DetailMapper detailMapper;

	public DetailService(
			DetailRepository detailRepository,
			DetailMapper detailMapper
	) {
		super(detailRepository, detailMapper);
		this.detailRepository = detailRepository;
		this.detailMapper = detailMapper;
	}

	public RefundDto makeRefund(Long detailId, RefundRequest refundRequest) {
		Detail detail = getEntityByIdOrThrow(detailId);
		Refund refund = detail.getRefund();
		if (refund == null) {
			refund = Refund.builder()
					.id(detailId)
					.customerRefundDate(refundRequest.getCustomerRefundDate())
					.supplierRefundDate(refundRequest.getSupplierRefundDate())
					.detail(detail)
					.build();
		}

		detail.setRefund(refund);
		return RefundDto.builder()
				.id(refund.getId())
				.supplierRefundDate(refund.getSupplierRefundDate())
				.customerRefundDate(refund.getCustomerRefundDate())
				.build();
	}
}
