package com.app.rentacar.dto;
import lombok.Data;

import java.util.Set;
import java.util.UUID;

@Data
public class ModelDto {
    private UUID id;
    private String name;

    private Set<CarDto> cars;
}
