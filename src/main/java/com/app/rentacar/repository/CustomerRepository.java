package com.app.rentacar.repository;

import com.app.rentacar.entity.payment.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CustomerRepository extends JpaRepository<UUID, Customer> {
}