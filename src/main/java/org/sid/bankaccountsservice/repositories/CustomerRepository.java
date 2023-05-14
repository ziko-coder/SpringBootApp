package org.sid.bankaccountsservice.repositories;

import org.sid.bankaccountsservice.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {


}
