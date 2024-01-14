package com.app.rentacar.entity.payment;

import com.app.rentacar.constant.MessageConstants;
import com.app.rentacar.entity.base.BaseEntity;
import com.app.rentacar.entity.enums.AccountType;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.math.BigDecimal;
import java.util.Set;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SQLDelete(sql = "UPDATE account SET status = 0 WHERE id=?")
@Where(clause = "status=1")
public class Account extends BaseEntity {

    @DecimalMin(value = "0.00", message = MessageConstants.RENTACAR_INCORRECT_AMOUNT_FORMAT)
    @NotNull(message = MessageConstants.RENTACAR_EMPTY_FIELD)
    @Digits(integer = 18, fraction = 2, message = MessageConstants.RENTACAR_INCORRECT_AMOUNT_FORMAT)
    @Column(nullable = false)
    private BigDecimal balance;

    @NotBlank(message = MessageConstants.RENTACAR_EMPTY_FIELD)
    @Column(nullable = false)
    private String accountName;

    @NotBlank(message = MessageConstants.RENTACAR_EMPTY_FIELD)
    @Column(nullable = false)
    private String accountNumber;

    @NotNull(message = MessageConstants.RENTACAR_EMPTY_FIELD)
    @Column(nullable = false)
    private AccountType type;

    @NotBlank(message = MessageConstants.RENTACAR_EMPTY_FIELD)
    @Column(nullable = false)
    private String customerNumber;

    @OneToMany(mappedBy = "account", fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE})
    private Set<Transaction> transaction;
}
