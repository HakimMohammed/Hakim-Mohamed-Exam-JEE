package mohamed.hakim.backend.repositories;

import mohamed.hakim.backend.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Long> {
    List<Client> findByNomContainingIgnoreCase(String nom);
    List<Client> findByEmailContainingIgnoreCase(String email);
}