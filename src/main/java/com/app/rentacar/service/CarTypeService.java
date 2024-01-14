package com.app.rentacar.service;

import com.app.rentacar.dto.car.CarTypeDto;
import com.app.rentacar.entity.car.CarType;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;
import java.util.UUID;

public interface CarTypeService {
    List<CarTypeDto> getAll(Specification<CarType> spec);

    CarTypeDto save(CarTypeDto carTypeDto);

    CarTypeDto update(CarTypeDto carTypeDto);

    void delete(UUID id);
}
