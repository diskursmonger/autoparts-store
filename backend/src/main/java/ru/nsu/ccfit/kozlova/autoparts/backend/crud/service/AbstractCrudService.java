package ru.nsu.ccfit.kozlova.autoparts.backend.crud.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import ru.nsu.ccfit.kozlova.autoparts.backend.crud.data.Mapper;

import javax.persistence.EntityNotFoundException;

public abstract class AbstractCrudService<E, DTO, CR, UR, ID> implements CrudService<DTO, CR, UR, ID> {

    private final JpaRepository<E, ID> crudRepository;
    private final Mapper<E, DTO, CR, UR> mapper;

    protected AbstractCrudService(
        JpaRepository<E, ID> crudRepository,
        Mapper<E, DTO, CR, UR> mapper
    ) {
        this.crudRepository = crudRepository;
        this.mapper = mapper;
    }

    @Override
    @Transactional
    public DTO create(CR createRequest) {
        var entity = mapper.createEntity(createRequest);
        return save(entity);
    }

    @Override
    @Transactional
    public DTO get(ID id) {
        E entity = getEntityByIdOrThrow(id);
        return mapper.toDto(entity);
    }

    @Override
    @Transactional
    public Page<DTO> getAll(Pageable pageable) {
        return crudRepository
                .findAll(pageable)
                .map(mapper::toDto);
    }

    @Override
    @Transactional
    public DTO update(ID id, UR updateRequest) {
        var entity = getEntityByIdOrThrow(id);
        mapper.updateEntity(entity, updateRequest);
        return save(entity);
    }

    @Override
    @Transactional
    public void delete(ID id) {
        crudRepository.deleteById(id);
    }

    private DTO save(E entity) {
        entity = crudRepository.save(entity);
        return mapper.toDto(entity);
    }

    protected E getEntityByIdOrThrow(ID id) {
        return getEntityByIdOrThrow(crudRepository, id);
    }

    protected <X, I> X getEntityByIdOrThrow(JpaRepository<X, I> repository, I id) {
        return repository.findById(id).orElseThrow(() ->
                new EntityNotFoundException(
                        String.format("Entity with id '%s' was not found", id)
                )
        );
    }

}