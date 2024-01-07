package com.app.rentacar.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Set;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
public class CarTypeDto extends BaseDto{
    private String type;

    private Set<CarDto> cars;
}
