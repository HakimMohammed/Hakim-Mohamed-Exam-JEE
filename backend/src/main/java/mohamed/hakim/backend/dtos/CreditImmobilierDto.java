package mohamed.hakim.backend.dtos;

import lombok.Value;
import mohamed.hakim.backend.enums.StatutCredit;
import mohamed.hakim.backend.enums.TypeBienImmobilier;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * DTO for {@link mohamed.hakim.backend.entities.CreditImmobilier}
 */
@Value
public class CreditImmobilierDto implements Serializable {
    Long id;
    LocalDate dateDemande;
    StatutCredit statut;
    LocalDate dateAcception;
    Double montant;
    Integer dureeRemboursement;
    Double tauxInteret;
    TypeBienImmobilier typeBien;
}