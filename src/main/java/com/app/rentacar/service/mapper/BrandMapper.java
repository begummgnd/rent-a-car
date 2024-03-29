package com.app.rentacar.service.mapper;

import com.app.rentacar.dto.car.BrandDto;
import com.app.rentacar.entity.car.Brand;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
@Mapper(componentModel = "spring" , uses = {CarMapper.class}, builder = @Builder(disableBuilder = true))
public interface BrandMapper extends BaseMapper<Brand, BrandDto>{



}
