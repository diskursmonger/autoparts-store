package ru.nsu.ccfit.kozlova.autoparts.app.gui.forms.input.details;

import ru.nsu.ccfit.kozlova.autoparts.app.gui.controllers.EntityInputFormController;
import ru.nsu.ccfit.kozlova.autoparts.app.gui.forms.input.AbstractEntityInputFormBuilder;
import ru.nsu.ccfit.kozlova.autoparts.app.model.details.DetailCreateRequest;
import ru.nsu.ccfit.kozlova.autoparts.app.model.details.DetailUpdateRequest;
import ru.nsu.ccfit.kozlova.autoparts.app.model.details.RefundDto;
import ru.nsu.ccfit.kozlova.autoparts.app.model.details.RefundRequest;
import ru.nsu.ccfit.kozlova.autoparts.app.utils.RequestExecutor;
import ru.nsu.ccfit.kozlova.autoparts.app.utils.ServiceFactory;

public class RefundInputFormBuilder extends AbstractEntityInputFormBuilder<RefundDto, RefundRequest, RefundRequest> {

	public RefundInputFormBuilder(RequestExecutor requestExecutor) {
		super(
				"Возврат детали",
				requestExecutor,
				RefundRequest::new,
				r -> new RefundRequest(r.getId(), r.getCustomerRefundDate(), r.getSupplierRefundDate()),
				cr -> ServiceFactory.getDetailService().makeRefund(cr.getDetailId(), cr),
				(id, refundRequest) -> ServiceFactory.getDetailService().makeRefund(id, refundRequest)
		);

	}

	@Override
	public void fillCreateInputForm(
			RefundRequest createRequest,
			EntityInputFormController<RefundRequest, RefundDto> controller,
			boolean isContextWindow
	) {

	}

	@Override
	public void fillEditInputForm(
			RefundRequest updateRequest,
			EntityInputFormController<RefundRequest, RefundDto> controller,
			boolean isContextWindow
	) {

		if (!isContextWindow) {
			updateRequest.setSupplierRefundDate(null);
			updateRequest.setCustomerRefundDate(null);
		}

		controller.addDateField(
				"Дата возврата клиентом",
				updateRequest.getCustomerRefundDate(),
				updateRequest::setCustomerRefundDate
		);

		controller.addNullableDateField(
				"Дата возврата поставщику",
				updateRequest.getSupplierRefundDate(),
				updateRequest::setSupplierRefundDate
		);
	}
}
