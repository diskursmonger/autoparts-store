package ru.nsu.ccfit.kozlova.autoparts.backend.sales.orders;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.sales.orders.OrderCreateRequest;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.sales.orders.OrderDto;
import ru.nsu.ccfit.kozlova.autoparts.backend.model.sales.orders.OrderUpdateRequest;
import ru.nsu.ccfit.kozlova.autoparts.backend.crud.service.AbstractCrudService;
import ru.nsu.ccfit.kozlova.autoparts.backend.details.types.DetailType;
import ru.nsu.ccfit.kozlova.autoparts.backend.details.types.DetailTypeRepository;

@Service
@Transactional
public class OrderService extends AbstractCrudService<
		Order, OrderDto, OrderCreateRequest, OrderUpdateRequest, Long> {

	private final OrderRepository orderRepository;
	private final OrderMapper orderMapper;
	private final DetailTypeRepository detailTypeRepository;

	public OrderService(
			OrderRepository orderRepository,
			OrderMapper orderMapper,
			DetailTypeRepository detailTypeRepository
	) {
		super(orderRepository, orderMapper);
		this.orderRepository = orderRepository;
		this.orderMapper = orderMapper;
		this.detailTypeRepository = detailTypeRepository;
	}

	public OrderDto setOrderDetailTypeAmount(Long orderId, Long detailTypeId, Integer amount) {
		Order order = getEntityByIdOrThrow(orderId);
		var orderDetailTypeAmount = order.getOrderDetailTypeAmounts()
				.stream()
				.filter(detailTypeAmount -> detailTypeAmount.getId().detailTypeId.equals(detailTypeId))
				.findFirst().orElse(null);

		if (orderDetailTypeAmount != null) {
			order.getOrderDetailTypeAmounts().remove(orderDetailTypeAmount);
		}

		if (amount > 0) {
			OrderDetailTypeAmount orderDetailTypeAmountToChange = orderDetailTypeAmount;
			if (orderDetailTypeAmountToChange == null) {
				DetailType detailType = getEntityByIdOrThrow(detailTypeRepository, detailTypeId);
				var id = OrderDetailTypeAmount.OrderDetailTypeAmountId
						.builder()
						.detailTypeId(detailTypeId)
						.orderId(orderId)
						.build();

				orderDetailTypeAmountToChange = OrderDetailTypeAmount.builder()
						.order(order)
						.detailType(detailType)
						.id(id)
						.build();
			}

			orderDetailTypeAmountToChange.setAmount(amount);
			order.getOrderDetailTypeAmounts().add(orderDetailTypeAmountToChange);
		}

		return orderMapper.toDto(order);
	}

	public void deleteOrderDetailType(Long orderId, Long detailTypeId) {
		getEntityByIdOrThrow(orderId)
				.getOrderDetailTypeAmounts()
				.removeIf(detailTypeAmount -> detailTypeAmount.getId().detailTypeId.equals(detailTypeId));
	}

}
