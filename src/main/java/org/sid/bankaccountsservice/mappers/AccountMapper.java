package org.sid.bankaccountsservice.mappers;


import com.fasterxml.jackson.databind.util.BeanUtil;
import org.sid.bankaccountsservice.dto.BankAccountResponseDTO;
import org.sid.bankaccountsservice.entities.BankAccount;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {
    public BankAccountResponseDTO fromBankAccount(BankAccount bankAccount) {
        BankAccountResponseDTO bankAccountResponseDTO = new BankAccountResponseDTO();
        BeanUtils.copyProperties(bankAccount ,bankAccountResponseDTO);
        return bankAccountResponseDTO;
    }
}
