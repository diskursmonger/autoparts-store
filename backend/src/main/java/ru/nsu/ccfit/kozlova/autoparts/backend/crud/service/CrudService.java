package ru.nsu.ccfit.kozlova.autoparts.backend.crud.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CrudService<DTO, CR, UR, ID> {

    DTO create(CR createRequest);

    DTO get(ID id);

    Page<DTO> getAll(Pageable pageable);

    DTO update(ID id, UR updateRequest);

    void delete(ID id);

}