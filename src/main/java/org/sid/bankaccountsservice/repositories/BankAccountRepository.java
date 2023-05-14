package org.sid.bankaccountsservice.repositories;

import org.sid.bankaccountsservice.entities.BankAccount;
import org.sid.bankaccountsservice.enums.AccountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;


@RepositoryRestResource
public interface BankAccountRepository extends JpaRepository<BankAccount, String> {
    @RestResource(path = "/byType") // alis pour le nom de la fonction
    List<BankAccount> findByType(@Param("t") AccountType type); // alias pour le parametre



}
