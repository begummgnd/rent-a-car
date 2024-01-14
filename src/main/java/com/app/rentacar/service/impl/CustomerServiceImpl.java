package com.app.rentacar.service.impl;

import com.app.rentacar.dto.payment.CustomerDto;
import com.app.rentacar.repository.CustomerRepository;
import com.app.rentacar.service.CustomerService;
import com.app.rentacar.service.mapper.CustomerMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository repository;
    private final CustomerMapper mapper;

    protected CustomerServiceImpl(CustomerRepository repository, CustomerMapper mapper){
        this.repository = repository;
        this.mapper = mapper;
    }
    @Override
    @Transactional
    public CustomerDto createCustomer(CustomerDto dto) {
        return null;
    }

    @Override
    public List<CustomerDto> getAllCustomers() {
        return null;
    }
}
