package com.app.rentacar.model;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.Set;
import java.util.UUID;

@Table(name = "model")
@Entity
public class Model {

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID" , strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @Column(name= "name")
    private String name;

    @OneToMany(mappedBy = "model", cascade = CascadeType.ALL)
    private Set<Car> cars;

    public Model() {
    }

    public Model(UUID id, String name, Set<Car> cars) {
        this.id = id;
        this.name = name;
        this.cars = cars;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Car> getCars() {
        return cars;
    }

    public void setCars(Set<Car> cars) {
        this.cars = cars;
    }

    }
