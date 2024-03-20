package com.mindhub.BankHub.dto.receiver;

public record LoanApplicationDTO(Long loanId, int payments, Double Amount, Double InterestRate, String DestinyAccountNumber) {
}
