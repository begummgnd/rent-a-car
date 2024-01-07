package com.app.rentacar.service.mapper;

import com.app.rentacar.dto.BaseDto;
import com.app.rentacar.entity.BaseEntity;

import java.util.List;

public interface BaseMapper<Entity extends BaseEntity, Dto extends BaseDto> {

    Dto entityToDto(Entity entity);

    Entity dtoToEntity(Dto dto);

    List<Dto> entityListToDtoList(List<Entity> list);
    List<Entity> dtoListToEntityList(List<Dto> list);

}
