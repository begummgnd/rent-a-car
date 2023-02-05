package com.app.rentacar.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.Set;
import java.util.UUID;

@Table(name = "car_type")
@Entity
public class CarType {
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID" , strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @Column(name= "type")
    private String type;

    @OneToMany(mappedBy = "carType" , cascade = CascadeType.ALL)
    private Set<Car> cars;

    public CarType() {
    }

    public CarType(UUID id, String type, Set<Car> cars) {
        this.id = id;
        this.type = type;
        this.cars = cars;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Set<Car> getCars() {
        return cars;
    }

    public void setCars(Set<Car> cars) {
        this.cars = cars;
    }
}
