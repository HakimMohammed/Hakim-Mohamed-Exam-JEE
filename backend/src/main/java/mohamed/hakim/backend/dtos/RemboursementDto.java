package mohamed.hakim.backend.dtos;

import lombok.Value;
import mohamed.hakim.backend.enums.TypeRemboursement;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * DTO for {@link mohamed.hakim.backend.entities.Remboursement}
 */
@Value
public class RemboursementDto implements Serializable {
    Long id;
    LocalDate date;
    Double montant;
    TypeRemboursement type;
}