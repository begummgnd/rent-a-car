package com.app.rentacar.repository;

import com.app.rentacar.entity.car.CarType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CarTypeRepository extends JpaRepository<CarType, UUID> , JpaSpecificationExecutor<CarType> {
}
