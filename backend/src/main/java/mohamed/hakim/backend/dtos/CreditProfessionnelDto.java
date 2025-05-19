package mohamed.hakim.backend.dtos;

import lombok.Data;
import lombok.Value;
import mohamed.hakim.backend.enums.StatutCredit;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * DTO for {@link mohamed.hakim.backend.entities.CreditProfessionnel}
 */
@Data
public class CreditProfessionnelDto extends CreditDto {
    Long id;
    LocalDate dateDemande;
    StatutCredit statut;
    LocalDate dateAcception;
    Double montant;
    Integer dureeRemboursement;
    Double tauxInteret;
    String motif;
    String raisonSociale;
}