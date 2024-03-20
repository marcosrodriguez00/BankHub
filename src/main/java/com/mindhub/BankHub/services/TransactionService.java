package com.mindhub.BankHub.services;

import com.mindhub.BankHub.dto.TransactionDTO;
import com.mindhub.BankHub.models.Transaction;

import java.util.List;

public interface TransactionService {

    List<Transaction> getAllTransactions();

    List<TransactionDTO> getAllTransactionDTO();

    Transaction getTransaction(Long id);

    TransactionDTO getTransactionDTO(Long id);

    void saveTransaction(Transaction transaction);

    void deleteTransactions(String accountNumber);
}
