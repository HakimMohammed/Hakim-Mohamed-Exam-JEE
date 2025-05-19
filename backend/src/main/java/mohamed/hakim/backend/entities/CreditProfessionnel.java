package mohamed.hakim.backend.entities;

import lombok.*;
import jakarta.persistence.*;

@Entity
@DiscriminatorValue("Professionnel")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreditProfessionnel extends Credit {
    private String motif;
    private String raisonSociale;
}
