package org.sid.ebankservice.service;

import org.sid.ebankservice.dto.BankAccountRequestDTO;
import org.sid.ebankservice.dto.BankAccountResponse;
import org.sid.ebankservice.entities.BankAccount;
import org.sid.ebankservice.mappers.AccountMapper;
import org.sid.ebankservice.repositories.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {
    @Autowired
    private BankAccountRepository bankAccountRepository;
    @Autowired
    private AccountMapper accountMapper;
    @Override
    public BankAccountResponse addAccount(BankAccountRequestDTO bankAccountDTO) {
        BankAccount bankAccount=BankAccount.builder()
                .id(UUID.randomUUID().toString())
                .createdAT((new Date()))
                .balance((bankAccountDTO.getBalance()))
                .type(bankAccountDTO.getType())
                .currency(bankAccountDTO.getCurrency())
                .build();
           BankAccount saveBankAccount= bankAccountRepository.save(bankAccount);
        BankAccountResponse bankAccountResponse = accountMapper.fromBankAccount(saveBankAccount);
        return bankAccountResponse;
    }
}
