package ru.nsu.ccfit.kozlova.autoparts.app.services.crud;

import com.google.gson.JsonElement;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.Map;

public interface CrudServiceApi {

    @GET("{root}/{id}")
    Call<JsonElement> get(
            @Path("root") String root,
            @Path("id") Long id
    );

    @GET("{root}")
    Call<JsonElement> getAll(
            @Path("root") String root,
            @QueryMap Map<String, Object> pageInfo
    );

    @POST("{root}")
    Call<JsonElement> create(
            @Path("root") String root,
            @Body JsonElement createRequest
    );

    @PUT("{root}/{id}")
    Call<JsonElement> update(
            @Path("root") String root,
            @Path("id") Long id,
            @Body JsonElement updateRequest
    );

    @DELETE("{root}/{id}")
    Call<Void> delete(
            @Path("root") String root,
            @Path("id") Long id
    );

}
