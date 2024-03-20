package com.mindhub.BankHub.services.implement;

import com.mindhub.BankHub.dto.ClientDTO;
import com.mindhub.BankHub.models.Client;
import com.mindhub.BankHub.repositories.ClientRepository;
import com.mindhub.BankHub.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class ClientImplement implements ClientService {

    @Autowired
    ClientRepository clientRepository;

    @Override
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public List<ClientDTO> getAllClientDTO() {
        return getAllClients().stream().map(ClientDTO::new).collect(toList());
    }

    @Override
    public Client getClientById(Long id) {
        return clientRepository.findById(id).orElse(null);
    }

    @Override
    public ClientDTO getClientDTOById(Long id) {
        return new ClientDTO(getClientById(id));
    }

    @Override
    public Client getClientByEmail(String email) {
        return clientRepository.findByEmail(email);
    }

    @Override
    public void saveClient(Client client) {
        clientRepository.save(client);
    }
}
