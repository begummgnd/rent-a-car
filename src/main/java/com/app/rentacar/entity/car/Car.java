package com.app.rentacar.entity.car;

import com.app.rentacar.entity.base.BaseEntity;
import com.app.rentacar.entity.enums.FuelType;
import com.app.rentacar.entity.enums.GearType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SQLDelete(sql = "UPDATE car SET status = 0 WHERE id=?")
@Where(clause = "status=1")
public class Car extends BaseEntity {

    @Column(name= "color", nullable = false)
    private String color;

    @Enumerated(EnumType.STRING)
    @Column(name = "fuel_type", nullable = false)
    private FuelType fuelType;

    @Enumerated(EnumType.STRING)
    @Column(name = "gear_type", nullable = false)
    private GearType gearType;

    @ManyToOne(fetch = FetchType.LAZY)
    private Brand brand;

    @ManyToOne(fetch = FetchType.LAZY)
    private Model model;

    @ManyToOne(fetch = FetchType.LAZY)
    private CarType carType;
}
