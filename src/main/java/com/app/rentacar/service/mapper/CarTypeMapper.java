package com.app.rentacar.service.mapper;

import com.app.rentacar.dto.CarTypeDto;
import com.app.rentacar.model.CarType;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {CarMapper.class})
public interface CarTypeMapper {

    CarTypeDto toDto(CarType carType);
    CarType toEntity(CarTypeDto carTypeDto);

}
