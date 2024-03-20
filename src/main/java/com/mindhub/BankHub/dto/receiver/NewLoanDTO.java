package com.mindhub.BankHub.dto.receiver;

import java.util.List;

public record NewLoanDTO(String name, Double maxAmount, Double interestRate, List<Integer> payments) {
}
