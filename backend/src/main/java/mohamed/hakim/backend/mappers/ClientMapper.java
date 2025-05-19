package mohamed.hakim.backend.mappers;

import mohamed.hakim.backend.dtos.ClientDto;
import mohamed.hakim.backend.entities.Client;
import org.springframework.stereotype.Service;

@Service
public class ClientMapper {
    public ClientDto toClientDto(Client client) {
        if (client == null) {
            return null;
        }
        ClientDto clientDTO = new ClientDto();
        clientDTO.setId(client.getId());
        clientDTO.setNom(client.getNom());
        clientDTO.setEmail(client.getEmail());
        return clientDTO;
    }

    public Client toClient(ClientDto clientDTO) {
        if (clientDTO == null) {
            return null;
        }
        Client client = new Client();
        client.setId(clientDTO.getId());
        client.setNom(clientDTO.getNom());
        client.setEmail(clientDTO.getEmail());
        return client;
    }
}
