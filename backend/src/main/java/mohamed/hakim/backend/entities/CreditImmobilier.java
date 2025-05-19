package mohamed.hakim.backend.entities;

import lombok.*;
import jakarta.persistence.*;
import mohamed.hakim.backend.enums.TypeBienImmobilier;

@Entity
@DiscriminatorValue("Immobilier")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreditImmobilier extends Credit {
    private TypeBienImmobilier typeBien;
}
