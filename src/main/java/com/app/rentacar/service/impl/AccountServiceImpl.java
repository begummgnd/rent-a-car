package com.app.rentacar.service.impl;

import com.app.rentacar.dto.payment.AccountDto;
import com.app.rentacar.repository.AccountRepository;
import com.app.rentacar.service.AccountService;
import com.app.rentacar.service.mapper.AccountMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class AccountServiceImpl implements AccountService {

    private final AccountRepository repository;
    private final AccountMapper mapper;

    protected AccountServiceImpl(AccountRepository repository, AccountMapper mapper){
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    @Transactional
    public AccountDto createAccount(AccountDto dto) {
        return null;
    }

    @Override
    public List<AccountDto> getAllAccountsByCustomerNumber(String customerNumber) {
        return null;
    }
}
