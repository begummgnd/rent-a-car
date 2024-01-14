package com.app.rentacar.dto.car;

import com.app.rentacar.dto.base.BaseDto;
import com.app.rentacar.entity.enums.FuelType;
import com.app.rentacar.entity.enums.GearType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;
@Data
@Builder
@AllArgsConstructor
public class CarDto extends BaseDto {
    private String color;

    private FuelType fuelType;

    private GearType gearType;

    private UUID brandId;

    private UUID modelId;

    private UUID carTypeId;

}
