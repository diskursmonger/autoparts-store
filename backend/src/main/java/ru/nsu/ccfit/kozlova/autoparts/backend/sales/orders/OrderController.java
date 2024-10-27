package ru.nsu.ccfit.kozlova.autoparts.backend.sales.orders;

import org.springframework.web.bind.annotation.*;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.sales.orders.OrderCreateRequest;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.sales.orders.OrderDto;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.sales.orders.OrderUpdateRequest;
import ru.nsu.ccfit.kozlova.autoparts.backend.crud.controller.AbstractCrudController;

@RestController
@RequestMapping("/orders")
public class OrderController extends AbstractCrudController<
		OrderDto, OrderCreateRequest, OrderUpdateRequest, Long> {

	private final OrderService orderService;

	public OrderController(OrderService orderService) {
		super(orderService);
		this.orderService = orderService;
	}

	@PutMapping("/{orderId}/detail-types/{detailTypeId}/amount")
	public OrderDto setDetailTypeAmount(
			@PathVariable Long orderId,
			@PathVariable Long detailTypeId,
			@RequestParam Integer amount
	) {
		return orderService.setOrderDetailTypeAmount(orderId, detailTypeId, amount);
	}

	@DeleteMapping("/{orderId}/detail-types/{detailTypeId}")
	public void deleteOrderDetailType(
			@PathVariable Long orderId,
			@PathVariable Long detailTypeId
	) {
		orderService.deleteOrderDetailType(orderId, detailTypeId);
	}

}
