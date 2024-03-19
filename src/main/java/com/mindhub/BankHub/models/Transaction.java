package com.mindhub.BankHub.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Transaction {
    // PROPERTIES

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private TransactionType type;

    private double amount, currentBalance;

    private LocalDateTime date;

    private String description;

    private boolean isActive;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="account_id")
    private Account account;

    // CONSTRUCTORS

    public Transaction() { }

    public Transaction( TransactionType type, double amount, String description, LocalDateTime date ){
        this.amount = amount;
        this.date = date;
        this.type = type;
        this.description = description;
        this.isActive = true;
    }

    // METHODS

    public long getId() {
        return id;
    }

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @JsonIgnore
    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public double getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(double currentBalance) {
        this.currentBalance = currentBalance;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
