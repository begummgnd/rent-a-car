package com.app.rentacar.service.mapper;

import com.app.rentacar.dto.ModelDto;
import com.app.rentacar.model.Model;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring" , uses = {CarMapper.class})
public interface ModelMapper {

    Model toEntity(ModelDto modelDto);

    ModelDto toDto(Model model);
}
