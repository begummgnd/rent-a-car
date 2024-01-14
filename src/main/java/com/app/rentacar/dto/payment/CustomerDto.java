package com.app.rentacar.dto.payment;

import com.app.rentacar.constant.MessageConstants;
import com.app.rentacar.dto.base.BaseDto;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class CustomerDto extends BaseDto {

    @NotBlank(message = MessageConstants.RENTACAR_EMPTY_FIELD)
    private String name;

    @NotBlank(message = MessageConstants.RENTACAR_EMPTY_FIELD)
    private String surname;

    private String customerNumber;
}
