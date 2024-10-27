package ru.nsu.ccfit.kozlova.autoparts.app.services.sales;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import ru.nsu.ccfit.kozlova.autoparts.app.model.sales.SaleDto;
import ru.nsu.ccfit.kozlova.autoparts.app.services.crud.CrudServiceApi;

public interface SaleServiceApi extends CrudServiceApi {

	@PUT("sales/{saleId}/details/{detailId}")
	Call<SaleDto> addDetail(
			@Path("saleId") Long saleId,
			@Path("detailId") Long detailId
	);

	@DELETE("sales/{saleId}/details/{detailId}")
	Call<Void> deleteDetail(
			@Path("saleId") Long saleId,
			@Path("detailId") Long detailId
	);

}
