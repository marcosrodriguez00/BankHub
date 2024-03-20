package com.mindhub.BankHub.services;

import com.mindhub.BankHub.dto.CardDTO;
import com.mindhub.BankHub.models.Card;
import com.mindhub.BankHub.models.CardColor;
import com.mindhub.BankHub.models.CardType;
import com.mindhub.BankHub.models.Client;

import java.util.List;

public interface CardService {

    Card getCardById(Long id);

    CardDTO getCardDTOById(Long id);

    List<CardDTO> getAllCardDTO();

    List<Card> getAllCards();

    Boolean existsCardByTypeAndColorAndClientAndIsActive(CardType cardType, CardColor cardColor, Client client, boolean isActive);

    Boolean existsCardByNumber(String cardNumber);

    void saveCard(Card card);

    Card getCardByNumber(String number);

    void deleteCardByNumber(String number);
}
