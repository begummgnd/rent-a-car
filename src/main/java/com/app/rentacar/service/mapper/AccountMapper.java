package com.app.rentacar.service.mapper;


import com.app.rentacar.dto.payment.AccountDto;
import com.app.rentacar.entity.payment.Account;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring" , uses = TransactionMapper.class, builder = @Builder(disableBuilder = true))
public interface AccountMapper extends BaseMapper<Account, AccountDto> {
}
