package com.mindhub.BankHub.repositories;

import com.mindhub.BankHub.models.Card;
import com.mindhub.BankHub.models.CardColor;
import com.mindhub.BankHub.models.CardType;
import com.mindhub.BankHub.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CardRepository extends JpaRepository<Card, Long> {

    boolean existsByNumber(String number);

    long countByType(CardType type);

    boolean existsByTypeAndColorAndClientAndIsActive(CardType type, CardColor color, Client client, boolean isActive);

    Card findByNumber(String number);
}
