package com.mindhub.BankHub.services.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class LoanUtils {
    public static LocalDateTime dateFormatter (LocalDateTime localDateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = localDateTime.format(formatter);

        return LocalDateTime.parse(formattedDateTime, formatter);
    }

    public static double addInterest ( double amount, double interestRate ) {
        return amount + (amount * interestRate);
    }
}
