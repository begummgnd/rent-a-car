package com.app.rentacar.dto;

import com.app.rentacar.entity.enums.FuelType;
import com.app.rentacar.entity.enums.GearType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;
@Data
@Builder
@AllArgsConstructor
public class CarDto extends BaseDto{
    private String color;

    private FuelType fuelType;

    private GearType gearType;

    private UUID brandId;

    private UUID modelId;

    private UUID carTypeId;

}
