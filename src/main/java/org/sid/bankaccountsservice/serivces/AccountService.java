package org.sid.bankaccountsservice.serivces;

import org.sid.bankaccountsservice.dto.BankAccountRequestDTO;
import org.sid.bankaccountsservice.dto.BankAccountResponseDTO;
import org.sid.bankaccountsservice.entities.BankAccount;
import org.sid.bankaccountsservice.enums.AccountType;

public interface AccountService {
    public BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountDTO);


    BankAccountResponseDTO updateAccount(String id, BankAccountRequestDTO bankAccountDTO);
}
