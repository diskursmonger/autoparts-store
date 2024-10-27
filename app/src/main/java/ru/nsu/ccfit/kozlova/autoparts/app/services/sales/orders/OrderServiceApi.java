package ru.nsu.ccfit.kozlova.autoparts.app.services.sales.orders;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;
import ru.nsu.ccfit.kozlova.autoparts.app.model.sales.orders.OrderDto;
import ru.nsu.ccfit.kozlova.autoparts.app.services.crud.CrudServiceApi;

public interface OrderServiceApi extends CrudServiceApi {

	@PUT("orders/{orderId}/detail-types/{detailTypeId}/amount")
	Call<OrderDto> setDetailTypeAmount(
			@Path("orderId") Long orderId,
			@Path("detailTypeId") Long detailTypeId,
			@Query("amount") Integer amount
	);

	@DELETE("orders/{orderId}/detail-types/{detailTypeId}")
	Call<Void> deleteOrderDetailType(
			@Path("orderId") Long orderId,
			@Path("detailTypeId") Long detailTypeId
	);

}
