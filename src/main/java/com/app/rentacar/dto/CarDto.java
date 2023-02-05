package com.app.rentacar.dto;

import com.app.rentacar.model.enums.FuelType;
import com.app.rentacar.model.enums.GearType;
import lombok.Data;

import java.util.UUID;
@Data
public class CarDto {

    private UUID id;

    private String color;

    private FuelType fuelType;

    private GearType gearType;

    private UUID brandId;

    private UUID modelId;

    private UUID carTypeId;

}
