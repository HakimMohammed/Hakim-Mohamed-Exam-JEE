package mohamed.hakim.backend.services;

import mohamed.hakim.backend.dtos.CreditDto;

import java.util.List;

public interface CreditService {
     CreditDto getCreditById(Long id);
     CreditDto createCredit(CreditDto creditDto);
     CreditDto updateCredit(Long id, CreditDto creditDto);
     void deleteCredit(Long id);
     List<CreditDto> getAllCredits();
}
