package mohamed.hakim.backend.services.impl;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mohamed.hakim.backend.dtos.CreditDto;
import mohamed.hakim.backend.dtos.CreditImmobilierDto;
import mohamed.hakim.backend.dtos.CreditPersonnelDto;
import mohamed.hakim.backend.dtos.CreditProfessionnelDto;
import mohamed.hakim.backend.entities.Credit;
import mohamed.hakim.backend.entities.CreditImmobilier;
import mohamed.hakim.backend.entities.CreditPersonnel;
import mohamed.hakim.backend.entities.CreditProfessionnel;
import mohamed.hakim.backend.mappers.CreditMapper;
import mohamed.hakim.backend.repositories.CreditRepository;
import mohamed.hakim.backend.services.CreditService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class CreditServiceImpl implements CreditService {

    private final CreditRepository creditRepository;
    private final CreditMapper creditMapper;

    @Override
    public CreditDto getCreditById(Long id) {
        Credit credit = creditRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Credit not found"));

        if (credit instanceof CreditImmobilier) {
            return creditMapper.toCreditImmobilierDto((CreditImmobilier) credit);
        } else if (credit instanceof CreditPersonnel) {
            return creditMapper.toCreditPersonnelDto((CreditPersonnel) credit);
        } else if (credit instanceof CreditProfessionnel) {
            return creditMapper.toCreditProfessionnelDto((CreditProfessionnel) credit);
        } else {
            throw new RuntimeException("Unknown credit type");
        }
    }

    @Override
    public CreditDto createCredit(CreditDto creditDto) {
        Credit credit;
        if (creditDto instanceof CreditImmobilierDto dto) {
            credit = creditMapper.toCreditImmobilier(dto);
        } else if (creditDto instanceof CreditPersonnelDto dto) {
            credit = creditMapper.toCreditPersonnel(dto);
        } else if (creditDto instanceof CreditProfessionnelDto dto) {
            credit = creditMapper.toCreditProfessionnel(dto);
        } else {
            throw new RuntimeException("Unknown credit type");
        }
        return creditMapper.toCreditDto(creditRepository.save(credit));
    }

    @Override
    public CreditDto updateCredit(Long id, CreditDto creditDto) {
        return creditRepository.findById(id)
                .map(existingCredit -> {
                    if (creditDto instanceof CreditImmobilierDto dto) {
                        creditMapper.updateCreditFromDto(dto, (CreditImmobilier) existingCredit);
                    } else if (creditDto instanceof CreditPersonnelDto dto) {
                        creditMapper.updateCreditFromDto(dto, (CreditPersonnel) existingCredit);
                    } else if (creditDto instanceof CreditProfessionnelDto dto) {
                        creditMapper.updateCreditFromDto(dto, (CreditProfessionnel) existingCredit);
                    } else {
                        throw new RuntimeException("Unknown credit type");
                    }
                    return creditMapper.toCreditDto(creditRepository.save(existingCredit));
                })
                .orElseThrow(() -> new RuntimeException("Credit not found"));
    }

    @Override
    public void deleteCredit(Long id) {
        creditRepository.findById(id)
                .ifPresentOrElse(credit -> {
                    creditRepository.delete(credit);
                    log.info("Credit with id {} deleted", id);
                }, () -> {
                    throw new RuntimeException("Credit not found");
                });
    }

    @Override
    public List<CreditDto> getAllCredits() {
        List<Credit> credits = creditRepository.findAll();
        return credits.stream()
                .map(credit -> {
                    if (credit instanceof CreditImmobilier) {
                        return creditMapper.toCreditImmobilierDto((CreditImmobilier) credit);
                    } else if (credit instanceof CreditPersonnel) {
                        return creditMapper.toCreditPersonnelDto((CreditPersonnel) credit);
                    } else if (credit instanceof CreditProfessionnel) {
                        return creditMapper.toCreditProfessionnelDto((CreditProfessionnel) credit);
                    } else {
                        throw new RuntimeException("Unknown credit type");
                    }
                })
                .toList();
    }
}