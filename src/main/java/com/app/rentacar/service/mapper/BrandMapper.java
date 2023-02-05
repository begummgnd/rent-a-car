package com.app.rentacar.service.mapper;

import com.app.rentacar.dto.BrandDto;
import com.app.rentacar.model.Brand;
import org.mapstruct.Mapper;
@Mapper(componentModel = "spring" , uses = {CarMapper.class})
public interface BrandMapper {

   BrandDto toDto(Brand brand);

   Brand toEntity(BrandDto brandDto);
}
