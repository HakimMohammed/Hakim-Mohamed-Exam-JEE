package mohamed.hakim.backend.services.impl;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mohamed.hakim.backend.dtos.RemboursementDto;
import mohamed.hakim.backend.mappers.RemboursementMapper;
import mohamed.hakim.backend.repositories.RemboursementRepository;
import mohamed.hakim.backend.services.RemboursementService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class RemboursementServiceImpl implements RemboursementService {
    private final RemboursementRepository remboursementRepository;
    private final RemboursementMapper remboursementMapper;


    @Override
    public RemboursementDto getRemboursementById(Long id) {
        return remboursementRepository.findById(id)
                .map(remboursementMapper::toRemboursementDto)
                .orElseThrow(() -> new RuntimeException("Remboursement not found"));
    }

    @Override
    public RemboursementDto createRemboursement(RemboursementDto remboursementDto) {
        return remboursementMapper.toRemboursementDto(remboursementRepository.save(remboursementMapper.toRemboursement(remboursementDto)));
    }

    @Override
    public RemboursementDto updateRemboursement(Long id, RemboursementDto remboursementDto) {
        return remboursementRepository.findById(id)
                .map(existingRemboursement -> {
                    existingRemboursement.setDate(remboursementDto.getDate());
                    existingRemboursement.setMontant(remboursementDto.getMontant());
                    existingRemboursement.setType(remboursementDto.getType());
                    return remboursementMapper.toRemboursementDto(remboursementRepository.save(existingRemboursement));
                })
                .orElseThrow(() -> new RuntimeException("Remboursement not found"));
    }

    @Override
    public void deleteRemboursement(Long id) {
        remboursementRepository.findById(id)
                .ifPresentOrElse(remboursement -> {
                    remboursementRepository.delete(remboursement);
                    log.info("Remboursement with id {} deleted", id);
                }, () -> {
                    throw new RuntimeException("Remboursement not found");
                });
    }

    @Override
    public List<RemboursementDto> getAllRemboursements() {
        return remboursementRepository.findAll()
                .stream()
                .map(remboursementMapper::toRemboursementDto)
                .toList();
    }
}
