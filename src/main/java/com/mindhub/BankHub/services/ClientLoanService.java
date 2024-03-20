package com.mindhub.BankHub.services;

import com.mindhub.BankHub.models.Client;
import com.mindhub.BankHub.models.ClientLoan;
import com.mindhub.BankHub.models.Loan;

public interface ClientLoanService {

    void saveClientLoan(ClientLoan clientLoan);

    ClientLoan getById(long id);

    boolean existsById(long id);

    boolean existsClientLoanByLoanAndClientAndIsActive(Loan loan, Client client, boolean isActive);
}
