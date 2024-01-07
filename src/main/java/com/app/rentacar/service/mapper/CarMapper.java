package com.app.rentacar.service.mapper;

import com.app.rentacar.dto.CarDto;
import com.app.rentacar.entity.Car;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface CarMapper extends BaseMapper<Car, CarDto>{

    @Mapping(source = "carType.id" , target = "carTypeId")
    @Mapping(source = "model.id" , target = "modelId")
    @Mapping(source = "brand.id" , target = "brandId")
    CarDto entityToDto(Car car);

    @Mapping(source = "carTypeId" , target = "carType.id")
    @Mapping(source = "modelId" , target = "model.id")
    @Mapping(source = "brandId" , target = "brand.id")
    Car dtoToEntity(CarDto carDto);

}
