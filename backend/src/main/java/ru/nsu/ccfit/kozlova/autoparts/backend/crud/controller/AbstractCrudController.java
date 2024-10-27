package ru.nsu.ccfit.kozlova.autoparts.backend.crud.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import ru.nsu.ccfit.kozlova.autoparts.backend.crud.service.CrudService;

public abstract class AbstractCrudController<DTO, CR, UR, ID> {

    private final CrudService<DTO, CR, UR, ID> crudService;

    protected AbstractCrudController(CrudService<DTO, CR, UR, ID> crudService) {
        this.crudService = crudService;
    }

    @GetMapping("/{id}")
    public DTO get(@PathVariable ID id) {
        return crudService.get(id);
    }

    @GetMapping
    public Page<DTO> getAll(Pageable pageable) {
        return crudService.getAll(pageable);
    }

    @PostMapping
    public DTO create(@RequestBody CR createRequest) {
        return crudService.create(createRequest);
    }

    @PutMapping("/{id}")
    public DTO update(@PathVariable ID id, @RequestBody UR updateRequest) {
        return crudService.update(id, updateRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable ID id) {
        crudService.delete(id);
    }

}