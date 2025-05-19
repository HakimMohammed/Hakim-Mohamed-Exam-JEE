package mohamed.hakim.backend.dtos;

import lombok.Value;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * DTO for {@link mohamed.hakim.backend.entities.Credit}
 */
@Value
public class CreditDto implements Serializable {
    Long id;
    LocalDate dateDemande;
    LocalDate dateAcception;
    Double montant;
    Integer dureeRemboursement;
    Double tauxInteret;
}