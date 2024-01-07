package com.app.rentacar.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.util.Set;

@Table(name = "brand")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SQLDelete(sql = "UPDATE brand SET status = 0 WHERE id=?")
@Where(clause = "status=1")
public class Brand extends BaseEntity {
    @Column(name= "name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "brand" , cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Car> cars;

}
