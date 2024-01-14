package com.app.rentacar.service.mapper;


import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring" , uses = TransactionMapper.class, builder = @Builder(disableBuilder = true))
public interface AccountMapper {
}
