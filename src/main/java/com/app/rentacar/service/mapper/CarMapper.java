package com.app.rentacar.service.mapper;

import com.app.rentacar.dto.CarDto;
import com.app.rentacar.model.Car;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CarMapper {

    @Mapping(source = "carType.id" , target = "carTypeId")
    @Mapping(source = "model.id" , target = "modelId")
    @Mapping(source = "brand.id" , target = "brandId")
    CarDto toDto(Car car);

    @Mapping(source = "carTypeId" , target = "carType.id")
    @Mapping(source = "modelId" , target = "model.id")
    @Mapping(source = "brandId" , target = "brand.id")
    Car toEntity(CarDto carDto);

}
