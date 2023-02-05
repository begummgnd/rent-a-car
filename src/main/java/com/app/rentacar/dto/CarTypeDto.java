package com.app.rentacar.dto;

import com.app.rentacar.model.Car;
import lombok.Data;

import java.util.Set;
import java.util.UUID;

@Data
public class CarTypeDto {

    private UUID id;

    private String type;

    private Set<CarDto> cars;
}
