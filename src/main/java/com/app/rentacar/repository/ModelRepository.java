package com.app.rentacar.repository;

import com.app.rentacar.entity.car.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ModelRepository extends JpaRepository<Model, UUID> , JpaSpecificationExecutor<Model> {
}
