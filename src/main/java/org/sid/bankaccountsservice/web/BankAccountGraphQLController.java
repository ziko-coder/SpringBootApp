package org.sid.bankaccountsservice.web;

import org.sid.bankaccountsservice.dto.BankAccountRequestDTO;
import org.sid.bankaccountsservice.dto.BankAccountResponseDTO;
import org.sid.bankaccountsservice.entities.BankAccount;
import org.sid.bankaccountsservice.repositories.BankAccountRepository;
import org.sid.bankaccountsservice.serivces.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;


@Controller
public class BankAccountGraphQLController {

    @Autowired
    private BankAccountRepository bankAccountRepository;
    @Autowired
    private AccountService accountService;


    @QueryMapping
    public List<BankAccount> accountsList() {
        return bankAccountRepository.findAll();
    }

    @QueryMapping
    public BankAccount bankAccountById(@Argument String id) {
        return bankAccountRepository.findById(id).orElseThrow(
                ()-> new RuntimeException(String.format("Account %s not found", id))
        );
    }

    @MutationMapping
    public BankAccountResponseDTO addAccount(@Argument BankAccountRequestDTO bankAccount) {
        return accountService.addAccount(bankAccount);
    }

    @MutationMapping
    public BankAccountResponseDTO updateAccount(@Argument String id ,@Argument BankAccountRequestDTO bankAccount) {
        return accountService.updateAccount(id, bankAccount);
    }

    @MutationMapping
    public Boolean deleteAccount(@Argument String id ) {
        bankAccountRepository.deleteById(id);
        return true;
    }
}

