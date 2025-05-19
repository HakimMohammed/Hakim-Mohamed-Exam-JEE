package mohamed.hakim.backend.repositories;

import mohamed.hakim.backend.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}