package org.sid.bankaccountsservice.web;


import org.sid.bankaccountsservice.dto.BankAccountRequestDTO;
import org.sid.bankaccountsservice.dto.BankAccountResponseDTO;
import org.sid.bankaccountsservice.entities.BankAccount;
import org.sid.bankaccountsservice.mappers.AccountMapper;
import org.sid.bankaccountsservice.repositories.BankAccountRepository;
import org.sid.bankaccountsservice.serivces.AccountService;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class AccountrestController {

    private BankAccountRepository bankAccountRepository;
    private AccountService accountService;
    private AccountMapper accountMapper;
    public AccountrestController(BankAccountRepository bankAccountRepository, AccountService accountService, AccountMapper accountMapper) {
        this.bankAccountRepository = bankAccountRepository;
        this.accountService = accountService;
        this.accountMapper = accountMapper;
    }

    @GetMapping("/bankAccounts")
    public List<BankAccount> bankAccountsList() {
        return bankAccountRepository.findAll();
    }

    @GetMapping("/bankAccounts/{id}")
    public BankAccount bankAccount(@PathVariable String id) {
        return bankAccountRepository.findById(id).orElseThrow(
                ()-> new RuntimeException(String.format("Account Not %s Fount", id)) );
    }

    @PostMapping("/bankAccounts")
    public BankAccountResponseDTO save(@RequestBody BankAccountRequestDTO requestDTO) {
        return accountService.addAccount(requestDTO);
    }

    @PutMapping("/bankAccounts/{id}")
    public BankAccount update(@PathVariable String id, @RequestBody BankAccount bankAccount) {
        BankAccount account = bankAccountRepository.findById(id).orElseThrow();
        if (bankAccount.getBalance() != null)   account.setBalance(bankAccount.getBalance());
        if (bankAccount.getCreatedAt() != null)   account.setCreatedAt(new Date());
        if (bankAccount.getType() != null)    account.setType(bankAccount.getType());
        if (bankAccount.getCurrency() != null)    account.setCurrency(bankAccount.getCurrency());
        return bankAccountRepository.save(account);
    }

     @DeleteMapping("/bankAccounts/{id}")
    public void DeleteAccount(@PathVariable String id) {
        bankAccountRepository.deleteById(id);
     }



}
