package ru.nsu.ccfit.kozlova.autoparts.app.services.deliveries;

import retrofit2.Call;
import retrofit2.http.*;
import ru.nsu.ccfit.kozlova.autoparts.app.model.deliveries.CustomRequest;
import ru.nsu.ccfit.kozlova.autoparts.app.model.deliveries.DeliveryDto;
import ru.nsu.ccfit.kozlova.autoparts.app.services.crud.CrudServiceApi;

public interface DeliveryServiceApi extends CrudServiceApi {

	@PUT("deliveries/{deliveryId}/details/{detailId}")
	Call<DeliveryDto> addDetail(
			@Path("deliveryId") Long deliveryId,
			@Path("detailId") Long detailId
	);

	@DELETE("deliveries/{deliveryId}/details/{detailId}")
	Call<Void> deleteDetail(
			@Path("deliveryId") Long deliveryId,
			@Path("detailId") Long detailId
	);

	@PUT("deliveries/{deliveryId}/prices/{detailTypeId}")
	Call<DeliveryDto> setDetailTypePrice(
			@Path("deliveryId") Long deliveryId,
			@Path("detailTypeId") Long detailTypeId,
			@Query("price") Double price
	);

	@DELETE("deliveries/{deliveryId}/prices/{detailTypeId}")
	Call<Void> deleteDetailTypePrice(
			@Path("deliveryId") Long deliveryId,
			@Path("detailTypeId") Long detailTypeId
	);

	@PUT("deliveries/{deliveryId}/custom")
	Call<Void> setCustom(
			@Path("deliveryId") Long deliveryId,
			@Body CustomRequest customRequest
	);

}
