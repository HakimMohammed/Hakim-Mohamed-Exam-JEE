package mohamed.hakim.backend.dtos;

import lombok.Data;
import lombok.Value;
import mohamed.hakim.backend.enums.StatutCredit;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * DTO for {@link mohamed.hakim.backend.entities.Credit}
 */
@Data
public class CreditDto {
    Long id;
    LocalDate dateDemande;
    LocalDate dateAcception;
    StatutCredit statut;
    Double montant;
    Integer dureeRemboursement;
    Double tauxInteret;
}