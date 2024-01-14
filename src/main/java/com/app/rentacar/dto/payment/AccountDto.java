package com.app.rentacar.dto.payment;

import com.app.rentacar.constant.MessageConstants;
import com.app.rentacar.dto.base.BaseDto;
import com.app.rentacar.entity.enums.AccountType;
import com.app.rentacar.entity.payment.Customer;
import com.app.rentacar.entity.payment.Transaction;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
public class AccountDto extends BaseDto {
    @DecimalMin(value = "0.00", message = MessageConstants.RENTACAR_INCORRECT_AMOUNT_FORMAT)
    @NotNull(message = MessageConstants.RENTACAR_EMPTY_FIELD)
    @Digits(integer = 18, fraction = 2, message = MessageConstants.RENTACAR_INCORRECT_AMOUNT_FORMAT)
    private BigDecimal balance;

    @NotBlank(message = MessageConstants.RENTACAR_EMPTY_FIELD)
    private String accountName;

    private String accountNumber;

    @NotBlank(message = MessageConstants.RENTACAR_EMPTY_FIELD)
    private String customerNumber;

    @NotNull(message = MessageConstants.RENTACAR_EMPTY_FIELD)
    private AccountType type;

    @Valid
    private Set<TransactionDto> transaction;
}
