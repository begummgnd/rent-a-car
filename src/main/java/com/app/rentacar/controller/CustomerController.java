package com.app.rentacar.controller;

import com.app.rentacar.dto.payment.CustomerDto;
import com.app.rentacar.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {

    private final CustomerService service;

    protected CustomerController(CustomerService service){
        this.service = service;
    }

    @PostMapping
    ResponseEntity<CustomerDto> createCustomer(@Valid CustomerDto dto){
        return new ResponseEntity<>(service.createCustomer(dto), HttpStatus.CREATED);
    }

    @GetMapping
    ResponseEntity<List<CustomerDto>> getAllCustomers(){
        return new ResponseEntity<>(service.getAllCustomers(), HttpStatus.OK);
    }
}
