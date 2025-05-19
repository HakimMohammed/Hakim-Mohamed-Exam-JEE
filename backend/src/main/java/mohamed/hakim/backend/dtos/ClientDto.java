package mohamed.hakim.backend.dtos;

import lombok.Data;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link mohamed.hakim.backend.entities.Client}
 */
@Data
public class ClientDto {
    Long id;
    String nom;
    String email;
}