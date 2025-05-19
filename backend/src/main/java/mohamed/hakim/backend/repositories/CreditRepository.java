package mohamed.hakim.backend.repositories;

import mohamed.hakim.backend.entities.Credit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditRepository extends JpaRepository<Credit, Long> {
}