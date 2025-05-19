package mohamed.hakim.backend.mappers;

import mohamed.hakim.backend.dtos.RemboursementDto;
import mohamed.hakim.backend.entities.Remboursement;
import org.springframework.stereotype.Service;

@Service
public class RemboursementMapper {
    public RemboursementDto toRemboursementDto(Remboursement remboursement) {
        if (remboursement == null) {
            return null;
        }
        RemboursementDto remboursementDTO = new RemboursementDto();
        remboursementDTO.setId(remboursement.getId());
        remboursementDTO.setDate(remboursement.getDate());
        remboursementDTO.setMontant(remboursement.getMontant());
        remboursementDTO.setType(remboursement.getType());
        return remboursementDTO;
    }

    public Remboursement toRemboursement(RemboursementDto remboursementDTO) {
        if (remboursementDTO == null) {
            return null;
        }
        Remboursement remboursement = new Remboursement();
        remboursement.setId(remboursementDTO.getId());
        remboursement.setDate(remboursementDTO.getDate());
        remboursement.setMontant(remboursementDTO.getMontant());
        remboursement.setType(remboursementDTO.getType());
        return remboursement;
    }
}
