package com.app.rentacar.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.util.Set;

@Table(name = "car-type")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SQLDelete(sql = "UPDATE car-type SET status = 0 WHERE id=?")
@Where(clause = "status=1")
public class CarType extends BaseEntity {

    @Column(name= "type", nullable = false)
    private String type;

    @OneToMany(mappedBy = "carType" , cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Car> cars;
}
