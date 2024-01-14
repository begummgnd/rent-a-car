package com.app.rentacar.dto.payment;

import com.app.rentacar.constant.MessageConstants;
import com.app.rentacar.dto.base.BaseDto;
import com.app.rentacar.entity.enums.TransactionType;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Builder
@Data
@AllArgsConstructor
public class TransactionDto extends BaseDto {
    @NotNull(message = MessageConstants.RENTACAR_EMPTY_FIELD)
    private TransactionType transactionType;

    @NotNull(message = MessageConstants.RENTACAR_EMPTY_FIELD)
    @DecimalMin(value = "0.00", inclusive = false, message = MessageConstants.RENTACAR_INCORRECT_AMOUNT_FORMAT)
    @Digits(integer = 18, fraction = 2, message = MessageConstants.RENTACAR_INCORRECT_AMOUNT_FORMAT)
    private BigDecimal amount;

    @NotBlank(message = MessageConstants.RENTACAR_EMPTY_FIELD)
    private String accountNumber;
    private String description;

}
