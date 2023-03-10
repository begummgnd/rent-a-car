package com.app.rentacar.service;

import com.app.rentacar.dto.ModelDto;
import com.app.rentacar.model.Model;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;
import java.util.UUID;

public interface ModelService {
    List<ModelDto> getAll(Specification<Model> spec);

    ModelDto save(ModelDto modelDto);

    ModelDto update(ModelDto modelDto);

    void delete(UUID id);
}
