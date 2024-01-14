package com.app.rentacar.service.mapper;

import com.app.rentacar.dto.payment.CustomerDto;
import com.app.rentacar.entity.payment.Customer;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface CustomerMapper extends BaseMapper<Customer, CustomerDto> {
}
