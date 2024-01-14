package com.app.rentacar.dto.car;

import com.app.rentacar.dto.base.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
@AllArgsConstructor
public class BrandDto extends BaseDto {
    private String name;

    private Set<CarDto> cars;

}
