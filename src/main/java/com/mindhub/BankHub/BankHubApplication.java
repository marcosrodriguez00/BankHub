package com.mindhub.BankHub;

import com.mindhub.BankHub.models.Client;
import com.mindhub.BankHub.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class BankHubApplication {

	public static void main(String[] args) {

		SpringApplication.run(BankHubApplication.class, args);
	}

	@Autowired
	public PasswordEncoder passwordEncoder;

	@Bean
	public CommandLineRunner initData(ClientRepository clientRepository,
									  AccountRepository accountRepository,
									  CardRepository cardRepository,
									  ClientLoanRepository clientLoanRepository,
									  LoanRepository loanRepository,
									  TransactionRepository transactionRepository){
		return args -> {
			Client Marcos = new Client("Marcos", "Rodríguez", "admin@test.com", passwordEncoder.encode("password"), true);
			clientRepository.save(Marcos);

			Client Melba = new Client("Melba", "Morel", "melba@bankhub.com", passwordEncoder.encode("melba123"), false);
			clientRepository.save(Melba);
		};
	}

}
