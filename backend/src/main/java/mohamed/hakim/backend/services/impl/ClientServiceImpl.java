package mohamed.hakim.backend.services.impl;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mohamed.hakim.backend.dtos.ClientDto;
import mohamed.hakim.backend.mappers.ClientMapper;
import mohamed.hakim.backend.repositories.ClientRepository;
import mohamed.hakim.backend.services.ClientService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    @Override
    public ClientDto getClientById(Long id) {
        return clientRepository.findById(id)
                .map(clientMapper::toClientDto)
                .orElseThrow(() -> new RuntimeException("Client not found"));
    }

    @Override
    public ClientDto createClient(ClientDto clientDto) {
        return clientMapper.toClientDto(clientRepository.save(clientMapper.toClient(clientDto)));
    }

    @Override
    public ClientDto updateClient(Long id, ClientDto clientDto) {
        return clientRepository.findById(id)
                .map(existingClient -> {
                    existingClient.setNom(clientDto.getNom());
                    existingClient.setEmail(clientDto.getEmail());
                    return clientMapper.toClientDto(clientRepository.save(existingClient));
                })
                .orElseThrow(() -> new RuntimeException("Client not found"));
    }

    @Override
    public void deleteClient(Long id) {
        clientRepository.findById(id)
                .ifPresentOrElse(client -> {
                    clientRepository.delete(client);
                    log.info("Client with id {} deleted", id);
                }, () -> {
                    throw new RuntimeException("Client not found");
                });
    }

    @Override
    public List<ClientDto> getAllClients() {
        return clientRepository.findAll()
                .stream()
                .map(clientMapper::toClientDto)
                .toList();
    }

    @Override
    public List<ClientDto> getClientsByNom(String nom) {
        return clientRepository.findByNomContainingIgnoreCase(nom)
                .stream()
                .map(clientMapper::toClientDto)
                .toList();
    }

    @Override
    public List<ClientDto> getClientsByEmail(String email) {
        return clientRepository.findByEmailContainingIgnoreCase(email)
                .stream()
                .map(clientMapper::toClientDto)
                .toList();
    }
}
