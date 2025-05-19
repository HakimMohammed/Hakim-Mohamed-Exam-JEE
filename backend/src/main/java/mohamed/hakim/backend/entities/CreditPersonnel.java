package mohamed.hakim.backend.entities;

import lombok.*;
import jakarta.persistence.*;

@Entity
@DiscriminatorValue("Personnel")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreditPersonnel extends Credit {
    private String motif;
}
