package org.sid.bankaccountsservice.entities;


import org.sid.bankaccountsservice.enums.AccountType;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = BankAccount.class, name = "p1")
public interface Accountprojection {

    public String getId();
    public AccountType getType();
    public Double getBalance();

}
