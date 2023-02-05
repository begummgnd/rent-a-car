package com.app.rentacar.model;

import com.app.rentacar.model.enums.FuelType;
import com.app.rentacar.model.enums.GearType;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import java.util.UUID;

@Table(name = "car")
@Entity
public class Car {

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID" , strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @Column(name= "color")
    private String color;

    @Enumerated(EnumType.STRING)
    @Column(name = "fuel_type")
    private FuelType fuelType;

    @Enumerated(EnumType.STRING)
    @Column(name = "gear_type")
    private GearType gearType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_id" , referencedColumnName = "id", nullable = false)
    private Brand brand;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "model_id" , referencedColumnName = "id", nullable = false)
    private Model model;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "car_type_id" , referencedColumnName = "id", nullable = false)
    private CarType carType;

    public Car() {
    }

    public Car(UUID id, String color, FuelType fuelType, GearType gearType, Brand brand, Model model, CarType carType) {
        this.id = id;
        this.color = color;
        this.fuelType = fuelType;
        this.gearType = gearType;
        this.brand = brand;
        this.model = model;
        this.carType = carType;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public void setFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
    }

    public GearType getGearType() {
        return gearType;
    }

    public void setGearType(GearType gearType) {
        this.gearType = gearType;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public CarType getCarType() {
        return carType;
    }

    public void setCarType(CarType carType) {
        this.carType = carType;
    }
}
