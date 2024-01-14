package com.app.rentacar.controller;

import com.app.rentacar.constant.ApiConstants;
import com.app.rentacar.dto.payment.AccountDto;
import com.app.rentacar.service.AccountService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ApiConstants.ACCOUNT)
public class AccountController {

    private final AccountService service;

    protected AccountController(AccountService service){
        this.service = service;
    }

    @PostMapping
    ResponseEntity<AccountDto> createAccount(@Valid @RequestBody AccountDto dto){
        return new ResponseEntity<>(service.createAccount(dto), HttpStatus.CREATED);
    }

    @GetMapping
    ResponseEntity<List<AccountDto>> getAllAccountsByCustomerNumber(@RequestParam String customerNumber){
        return new ResponseEntity<>(service.getAllAccountsByCustomerNumber(customerNumber), HttpStatus.OK);
    }
}
