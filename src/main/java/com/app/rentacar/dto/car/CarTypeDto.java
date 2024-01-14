package com.app.rentacar.dto.car;

import com.app.rentacar.dto.base.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
@AllArgsConstructor
public class CarTypeDto extends BaseDto {
    private String type;

    private Set<CarDto> cars;
}
