package mohamed.hakim.backend.services;

import mohamed.hakim.backend.dtos.RemboursementDto;

import java.util.List;

public interface RemboursementService {
     RemboursementDto getRemboursementById(Long id);
     RemboursementDto createRemboursement(RemboursementDto remboursementDto);
     RemboursementDto updateRemboursement(Long id, RemboursementDto remboursementDto);
     void deleteRemboursement(Long id);
     List<RemboursementDto> getAllRemboursements();
}
