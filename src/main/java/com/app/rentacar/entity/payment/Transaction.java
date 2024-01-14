package com.app.rentacar.entity.payment;

import com.app.rentacar.constant.MessageConstants;
import com.app.rentacar.entity.base.BaseEntity;
import com.app.rentacar.entity.enums.TransactionType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SQLDelete(sql = "UPDATE transaction SET status = 0 WHERE id=?")
@Where(clause = "status=1")
public class Transaction extends BaseEntity {

    @NotNull(message = MessageConstants.RENTACAR_EMPTY_FIELD)
    @Column(nullable = false)
    private TransactionType transactionType;

    @NotNull(message = MessageConstants.RENTACAR_EMPTY_FIELD)
    @DecimalMin(value = "0.00", inclusive = false, message = MessageConstants.RENTACAR_INCORRECT_AMOUNT_FORMAT)
    @Digits(integer = 18, fraction = 2, message = MessageConstants.RENTACAR_INCORRECT_AMOUNT_FORMAT)
    @Column(nullable = false)
    private BigDecimal amount;

    private String description;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Account account;
}
