package com.app.rentacar.service.mapper;

import com.app.rentacar.dto.car.ModelDto;
import com.app.rentacar.entity.car.Model;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring" , uses = {CarMapper.class}, builder = @Builder(disableBuilder = true))
public interface ModelMapper extends BaseMapper<Model, ModelDto> {
}
