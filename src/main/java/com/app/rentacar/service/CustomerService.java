package com.app.rentacar.service;

import com.app.rentacar.dto.payment.CustomerDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CustomerService {
    CustomerDto createCustomer(CustomerDto dto);

    List<CustomerDto> getAllCustomers();
}
