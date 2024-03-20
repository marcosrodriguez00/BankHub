package com.mindhub.BankHub.services;

import com.mindhub.BankHub.dto.ClientDTO;
import com.mindhub.BankHub.models.Client;

import java.util.List;

public interface ClientService {

    List<Client> getAllClients();

    List<ClientDTO> getAllClientDTO();

    Client getClientById(Long id);

    ClientDTO getClientDTOById(Long id);

    Client getClientByEmail(String email);

    void saveClient(Client client);
}
