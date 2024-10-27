 
package ru.nsu.ccfit.kozlova.autoparts.app.services.crud;

import ru.nsu.ccfit.kozlova.autoparts.app.services.crud.pagination.Page;
import ru.nsu.ccfit.kozlova.autoparts.app.services.crud.pagination.PageInfo;

public interface CrudService<DTO, CR, UR> {

    ServiceResponse<DTO> get(Long id);

    ServiceResponse<Page<DTO>> getAll(PageInfo pageInfo);

    ServiceResponse<DTO> create(CR createRequest);

    ServiceResponse<DTO> update(Long id, UR updateRequest);

    ServiceResponse<Void> delete(Long id);

}