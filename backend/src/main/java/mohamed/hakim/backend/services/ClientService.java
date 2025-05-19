package mohamed.hakim.backend.services;

import mohamed.hakim.backend.dtos.ClientDto;

import java.util.List;

public interface ClientService {
    ClientDto getClientById(Long id);

    ClientDto createClient(ClientDto clientDto);

    ClientDto updateClient(Long id, ClientDto clientDto);

    void deleteClient(Long id);

    List<ClientDto> getAllClients();

    List<ClientDto> getClientsByNom(String nom);

    List<ClientDto> getClientsByEmail(String email);
}
