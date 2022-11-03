package org.sid.ebankservice.mappers;

import com.fasterxml.jackson.databind.util.BeanUtil;
import org.sid.ebankservice.dto.BankAccountResponse;
import org.sid.ebankservice.entities.BankAccount;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {
    public BankAccountResponse fromBankAccount(BankAccount bankAccount)
    {
        BankAccountResponse bankAccountResponse=new BankAccountResponse();
        BeanUtils.copyProperties(bankAccount,bankAccountResponse);
        return bankAccountResponse;
    }

}
