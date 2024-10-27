package ru.nsu.ccfit.kozlova.autoparts.app.services.crud;

import com.google.gson.*;
import lombok.SneakyThrows;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.nsu.ccfit.kozlova.autoparts.app.services.crud.pagination.Page;
import ru.nsu.ccfit.kozlova.autoparts.app.services.crud.pagination.PageInfo;

import java.lang.reflect.Type;
import java.time.Instant;
import java.time.LocalDateTime;

public class AbstractService {

	protected static final Gson gson;

	private final Object serviceApi;

	static {
		gson = new GsonBuilder()
				.setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS")
				.create();

	}

	protected AbstractService(
			Class<?> serviceApiClass,
			String baseUrl
	) {
		Retrofit retrofit = new Retrofit.Builder()
				.baseUrl(baseUrl)
				.addConverterFactory(GsonConverterFactory.create(gson))
				.build();

		serviceApi = retrofit.create(serviceApiClass);
	}

	@SneakyThrows
	protected <X> ServiceResponse<X> getServerResponse(Call<X> call) {
		Response<X> response = call.execute();

		if (response.isSuccessful()) {
			return new ServiceResponse<>(response.body(), true, null);
		}

		return new ServiceResponse<>(null, false, getErrorMessage(response));
	}

	@SneakyThrows
	protected <X> ServiceResponse<X> getServerResponse(Call<JsonElement> call, Type bodyType) {
		Response<JsonElement> response = call.execute();
		JsonElement jsonResponseBody = response.body();

		if (response.isSuccessful()) {
			X responseBody = gson.fromJson(jsonResponseBody, bodyType);
			return new ServiceResponse<>(responseBody, true, null);
		}

		return new ServiceResponse<>(null, false, getErrorMessage(response));
	}

	@SneakyThrows
	private String getErrorMessage(Response<?> response) {
		if (response.errorBody() == null) {
			return "";
		}

		String jsonErrorBody = response.errorBody().string();
		AbstractService.ErrorResponseBody errorBody = gson.fromJson(jsonErrorBody, AbstractService.ErrorResponseBody.class);
		if (errorBody == null) {
			return "";
		}

		return errorBody.message;
	}

	private static class ErrorResponseBody {
		String message;
	}

	protected Object getServiceApi() {
		return serviceApi;
	}

}
