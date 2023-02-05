package com.app.rentacar.dto;

import com.app.rentacar.model.Car;
import lombok.Data;

import java.util.Set;
import java.util.UUID;

@Data
public class BrandDto {

    private UUID id;

    private String name;

    private Set<CarDto> cars;

}
