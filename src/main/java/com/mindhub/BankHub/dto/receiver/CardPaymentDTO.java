package com.mindhub.BankHub.dto.receiver;

public record CardPaymentDTO(String cardNumber, String paymentDescription, Double paymentAmount) {
}
