package com.mindhub.BankHub.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Client {

    // PROPERTIES

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName, lastName, email, password;

    private Boolean admin;

    @OneToMany(mappedBy = "client", fetch = FetchType.EAGER)
    private final Set<Account> accounts = new HashSet<>();

    @OneToMany(mappedBy = "client", fetch = FetchType.EAGER)
    private final Set<ClientLoan> clientLoans = new HashSet<>();

    @OneToMany(mappedBy = "client", fetch = FetchType.EAGER)
    private final Set<Card> cards = new HashSet<>();

    // CONSTRUCTORS

    public Client() {}

    public Client(String firstName, String lastName, String email, String password, Boolean admin) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.admin = admin;
    }

    // METHODS

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

    @JsonIgnore
    public Set<Account> getAccounts() {
        return accounts;
    }

    public void addAccount(Account account) {
        account.setClient(this);
        this.accounts.add(account);
    }

    @JsonIgnore
    public Set<ClientLoan> getClientLoans() {
        return clientLoans;
    }

    public void addClientLoan(ClientLoan clientLoan) {
        clientLoan.setClient(this);
        this.clientLoans.add(clientLoan);
    }

    @JsonIgnore
    public Set<Card> getCards() {
        return cards;
    }

    public void addCard(Card card) {
        card.setClient(this);
        this.cards.add(card);
    }

    public String fullName() {
        return this.firstName + " " + this.lastName;
    }
}
