package mohamed.hakim.backend.dtos;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link mohamed.hakim.backend.entities.Client}
 */
@Value
public class ClientDto implements Serializable {
    Long id;
    String nom;
    String email;
}