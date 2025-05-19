package mohamed.hakim.backend.dtos;

import lombok.Data;
import lombok.Value;
import mohamed.hakim.backend.enums.StatutCredit;
import mohamed.hakim.backend.enums.TypeBienImmobilier;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * DTO for {@link mohamed.hakim.backend.entities.CreditImmobilier}
 */
@Data
public class CreditImmobilierDto extends CreditDto{
    Long id;
    LocalDate dateDemande;
    StatutCredit statut;
    LocalDate dateAcception;
    Double montant;
    Integer dureeRemboursement;
    Double tauxInteret;
    TypeBienImmobilier typeBien;
}