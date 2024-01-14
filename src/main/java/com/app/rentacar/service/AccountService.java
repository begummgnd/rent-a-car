package com.app.rentacar.service;

import com.app.rentacar.dto.payment.AccountDto;

import java.util.List;

public interface AccountService {

    AccountDto createAccount(AccountDto dto);
    List<AccountDto> getAllAccountsByCustomerNumber(String customerNumber);

}
