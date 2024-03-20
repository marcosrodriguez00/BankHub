package com.mindhub.BankHub.repositories;

import com.mindhub.BankHub.models.Client;
import com.mindhub.BankHub.models.ClientLoan;
import com.mindhub.BankHub.models.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ClientLoanRepository extends JpaRepository<ClientLoan, Long> {
    ClientLoan findById(long id);

    boolean existsByLoanAndClientAndIsActive(Loan loan, Client client, boolean isActive);
}
