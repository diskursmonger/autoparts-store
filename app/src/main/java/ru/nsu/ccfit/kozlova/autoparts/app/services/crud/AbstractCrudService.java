package ru.nsu.ccfit.kozlova.autoparts.app.services.crud;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import lombok.SneakyThrows;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.nsu.ccfit.kozlova.autoparts.app.services.crud.pagination.Page;
import ru.nsu.ccfit.kozlova.autoparts.app.services.crud.pagination.PageInfo;

import java.lang.reflect.Type;

public abstract class AbstractCrudService<DTO, CR, UR>
        extends AbstractService implements CrudService<DTO, CR, UR> {

    private final String urlRoot;
    private final CrudServiceApi crudServiceApi;
    private final Class<DTO> dtoClass;

    protected AbstractCrudService(
            Class<? extends CrudServiceApi> serviceApiClass,
            Class<DTO> dtoClass,
            String baseUrl,
            String urlRoot
    ) {
        super(serviceApiClass, baseUrl);

        this.urlRoot = urlRoot;
        this.dtoClass = dtoClass;

        crudServiceApi = (CrudServiceApi) getServiceApi();
    }

    @Override
    public ServiceResponse<DTO> get(Long id) {
        var call = crudServiceApi.get(urlRoot, id);
        return getServerResponse(call, dtoClass);
    }

    @Override
    public ServiceResponse<Page<DTO>> getAll(PageInfo pageInfo) {
        var call = crudServiceApi.getAll(urlRoot, PageInfo.toMap(pageInfo));
        return getServerResponse(call, TypeFactory.getPageType(dtoClass));
    }

    @Override
    public ServiceResponse<DTO> create(CR createRequest) {
        var call = crudServiceApi.create(urlRoot, gson.toJsonTree(createRequest));
        return getServerResponse(call, dtoClass);
    }

    @Override
    public ServiceResponse<DTO> update(Long id, UR updateRequest) {
        var call = crudServiceApi.update(urlRoot, id, gson.toJsonTree(updateRequest));
        return getServerResponse(call, dtoClass);
    }

    @Override
    public ServiceResponse<Void> delete(Long id) {
        var call = crudServiceApi.delete(urlRoot, id);
        return getServerResponse(call);
    }

}
