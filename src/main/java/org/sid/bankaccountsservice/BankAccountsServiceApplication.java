package org.sid.bankaccountsservice;

import org.sid.bankaccountsservice.entities.BankAccount;
import org.sid.bankaccountsservice.entities.Customer;
import org.sid.bankaccountsservice.enums.AccountType;
import org.sid.bankaccountsservice.repositories.BankAccountRepository;
import org.sid.bankaccountsservice.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class BankAccountsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankAccountsServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(BankAccountRepository bankAccountRepository, CustomerRepository customerRepository) {
		return args -> {

			Stream.of("Khalid", "Zakaria", "Hannae", "BABA").forEach(
					c-> {
						Customer customer = Customer.builder()
								.name(c)
								.build();
						customerRepository.save(customer);
					}
			);

			 customerRepository.findAll().forEach(
					 customer -> {
						 for (int i=0; i<10; i++) {
							 BankAccount bankAccount = BankAccount.builder()
									 .id(UUID.randomUUID().toString())
									 .type(Math.random()>0.5 ? AccountType.CURRENT_ACCOUNT: AccountType.SAVING_ACCOUNT)
									 .balance((100+Math.random()*4829))
									 .createdAt(new Date())
									 .currency("MAD")
									 .customer(customer)
									 .build();
							 bankAccountRepository.save(bankAccount);
						 }
					 }
			 );


			for (int i=0; i<10; i++) {
					BankAccount bankAccount = BankAccount.builder()
							.id(UUID.randomUUID().toString())
							.type(Math.random()>0.5 ? AccountType.CURRENT_ACCOUNT: AccountType.SAVING_ACCOUNT)
							.balance((100+Math.random()*4829))
							.createdAt(new Date())
							.currency("MAD")
							.build();
					bankAccountRepository.save(bankAccount);
			}
		};
	}



}
