package ru.nsu.ccfit.kozlova.autoparts.app.services.sales.orders;

import ru.nsu.ccfit.kozlova.autoparts.app.model.sales.SaleDto;
import ru.nsu.ccfit.kozlova.autoparts.app.model.sales.orders.OrderCreateRequest;
import ru.nsu.ccfit.kozlova.autoparts.app.model.sales.orders.OrderDto;
import ru.nsu.ccfit.kozlova.autoparts.app.model.sales.orders.OrderUpdateRequest;
import ru.nsu.ccfit.kozlova.autoparts.app.services.crud.AbstractCrudService;
import ru.nsu.ccfit.kozlova.autoparts.app.services.crud.ServiceResponse;

public class OrderService extends AbstractCrudService<OrderDto, OrderCreateRequest, OrderUpdateRequest> {

	private final OrderServiceApi orderServiceApi;

	public OrderService(String baseUrl) {
		super(OrderServiceApi.class, OrderDto.class, baseUrl, "orders");
		orderServiceApi = (OrderServiceApi) getServiceApi();
	}

	public ServiceResponse<OrderDto> setDetailTypeAmount(Long orderId, Long detailTypeId, Integer amount) {
		var call = orderServiceApi.setDetailTypeAmount(orderId, detailTypeId, amount);
		return getServerResponse(call);
	}

	public ServiceResponse<Void> deleteOrderDetailType(Long orderId, Long detailTypeId) {
		var call = orderServiceApi.deleteOrderDetailType(orderId, detailTypeId);
		return getServerResponse(call);
	}

}
