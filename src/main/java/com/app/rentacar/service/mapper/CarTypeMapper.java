package com.app.rentacar.service.mapper;

import com.app.rentacar.dto.CarTypeDto;
import com.app.rentacar.entity.CarType;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {CarMapper.class}, builder = @Builder(disableBuilder = true))
public interface CarTypeMapper extends BaseMapper<CarType, CarTypeDto> {

}
