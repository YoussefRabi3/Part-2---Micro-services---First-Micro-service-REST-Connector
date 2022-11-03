package org.sid.ebankservice.service;

import org.sid.ebankservice.dto.BankAccountRequestDTO;
import org.sid.ebankservice.dto.BankAccountResponse;
import org.sid.ebankservice.entities.BankAccount;

public interface AccountService {
    public BankAccountResponse addAccount(BankAccountRequestDTO bankAccountDTO);
}
