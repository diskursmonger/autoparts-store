package ru.nsu.ccfit.kozlova.autoparts.backend.crud.data;

public interface Mapper<E, DTO, CR, UR> {

    E createEntity(CR createRequest);

    void updateEntity(E entity, UR updateRequest);

    DTO toDto(E entity);

}