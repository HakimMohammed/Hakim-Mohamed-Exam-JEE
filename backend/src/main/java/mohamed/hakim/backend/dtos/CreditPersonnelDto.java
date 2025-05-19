package mohamed.hakim.backend.dtos;

import lombok.Value;
import mohamed.hakim.backend.enums.StatutCredit;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * DTO for {@link mohamed.hakim.backend.entities.CreditPersonnel}
 */
@Value
public class CreditPersonnelDto implements Serializable {
    Long id;
    LocalDate dateDemande;
    StatutCredit statut;
    Double montant;
    LocalDate dateAcception;
    Integer dureeRemboursement;
    Double tauxInteret;
    String motif;
}