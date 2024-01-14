package com.app.rentacar.entity.payment;

import com.app.rentacar.constant.MessageConstants;
import com.app.rentacar.entity.base.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SQLDelete(sql = "UPDATE customer SET status = 0 WHERE id=?")
@Where(clause = "status=1")
public class Customer extends BaseEntity {

    @Column(nullable = false)
    @NotBlank(message = MessageConstants.RENTACAR_EMPTY_FIELD)
    private String name;

    @Column(nullable = false)
    @NotBlank(message = MessageConstants.RENTACAR_EMPTY_FIELD)
    private String surname;


    @Column(nullable = false)
    @NotBlank(message = MessageConstants.RENTACAR_EMPTY_FIELD)
    private String customerNumber;
}
