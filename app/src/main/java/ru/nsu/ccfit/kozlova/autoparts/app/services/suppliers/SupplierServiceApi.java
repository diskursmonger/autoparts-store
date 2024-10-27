package ru.nsu.ccfit.kozlova.autoparts.app.services.suppliers;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;
import ru.nsu.ccfit.kozlova.autoparts.app.model.suppliers.SupplierDto;
import ru.nsu.ccfit.kozlova.autoparts.app.model.suppliers.guarantees.GuaranteeDto;
import ru.nsu.ccfit.kozlova.autoparts.app.services.crud.CrudServiceApi;
import ru.nsu.ccfit.kozlova.autoparts.app.services.crud.pagination.Page;

import java.util.Map;

public interface SupplierServiceApi extends CrudServiceApi {

	@GET("suppliers/{supplierId}/guarantees")
	Call<Page<GuaranteeDto>> getSupplierGuarantees(
			@Path("supplierId") Long supplierId,
			@QueryMap Map<String, Object> pageInfo
	);

	@GET("suppliers")
	Call<Page<SupplierDto>> getAll(@QueryMap Map<String, Object> pageInfo);

}
