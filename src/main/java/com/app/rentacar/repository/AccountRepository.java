package com.app.rentacar.repository;

import com.app.rentacar.entity.payment.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AccountRepository extends JpaRepository<UUID, Account> {
}
