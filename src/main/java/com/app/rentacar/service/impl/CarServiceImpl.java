package com.app.rentacar.service.impl;

import com.app.rentacar.dto.CarDto;
import com.app.rentacar.entity.Car;
import com.app.rentacar.repository.CarRepository;
import com.app.rentacar.service.CarService;
import com.app.rentacar.service.mapper.CarMapper;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;

    private final CarMapper carMapper;

    public CarServiceImpl(CarRepository carRepository, CarMapper carMapper) {
        this.carRepository = carRepository;
        this.carMapper = carMapper;
    }

    @Override
    public List<CarDto> getAll(Specification<Car> spec) {
        List<Car> cars = carRepository.findAll(spec);
        List<CarDto> carDtos = cars
                                .stream()
                                .map(car -> carMapper.entityToDto(car))
                                .collect(Collectors.toList());
        return carDtos;
    }

    @Override
    public CarDto save(CarDto carDto) {
        Car car = carRepository.save(carMapper.dtoToEntity(carDto));
        carDto = carMapper.entityToDto(car);
        return carDto;
    }

    @Override
    public CarDto update(CarDto carDto) {
        Optional<Car> car = carRepository.findById(carDto.getId());
        if(!car.isPresent()){
            throw new NullPointerException();
        }
        carDto = save(carDto);
        return carDto;
    }

    @Override
    public void delete(UUID id) {

        Optional<Car> car = carRepository.findById(id);
        if(!car.isPresent()){
            throw new NullPointerException();
        }
        carRepository.delete(car.get());
    }
}
