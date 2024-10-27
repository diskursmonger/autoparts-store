package ru.nsu.ccfit.kozlova.autoparts.app.services.details;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import ru.nsu.ccfit.kozlova.autoparts.app.model.details.RefundDto;
import ru.nsu.ccfit.kozlova.autoparts.app.model.details.RefundRequest;
import ru.nsu.ccfit.kozlova.autoparts.app.services.crud.CrudServiceApi;

public interface DetailServiceApi extends CrudServiceApi {

	@PUT("details/{detailId}/refund")
	Call<RefundDto> makeRefund(
			@Path("detailId") Long detailId,
			@Body RefundRequest refundRequest
	);

}
