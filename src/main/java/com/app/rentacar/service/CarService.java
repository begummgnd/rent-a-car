package com.app.rentacar.service;

import com.app.rentacar.dto.car.CarDto;
import com.app.rentacar.entity.car.Car;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;
import java.util.UUID;

public interface CarService {

    List<CarDto> getAll(Specification<Car> spec);

    CarDto save(CarDto carDto);

    CarDto update(CarDto carDto);

    void delete(UUID id);
}
