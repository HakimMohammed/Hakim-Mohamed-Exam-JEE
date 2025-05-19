package mohamed.hakim.backend.controllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mohamed.hakim.backend.dtos.CreditDto;
import mohamed.hakim.backend.dtos.CreditImmobilierDto;
import mohamed.hakim.backend.dtos.CreditPersonnelDto;
import mohamed.hakim.backend.dtos.CreditProfessionnelDto;
import mohamed.hakim.backend.services.CreditService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/credits")
public class CreditController {

    private final CreditService creditService;

    public CreditController(CreditService creditService) {
        this.creditService = creditService;
    }

    @GetMapping
    public ResponseEntity<List<CreditDto>> getAllCredits() {
        return ResponseEntity.ok(creditService.getAllCredits());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CreditDto> getCreditById(@PathVariable Long id) {
        return ResponseEntity.ok(creditService.getCreditById(id));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCredit(@PathVariable Long id) {
        creditService.deleteCredit(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/personnel")
    public ResponseEntity<CreditPersonnelDto> createCreditPersonnel(@RequestBody CreditPersonnelDto dto) {
        return ResponseEntity.ok((CreditPersonnelDto) creditService.createCredit(dto));
    }

    @PostMapping("/immobilier")
    public ResponseEntity<CreditImmobilierDto> createCreditImmobilier(@RequestBody CreditImmobilierDto dto) {
        return ResponseEntity.ok((CreditImmobilierDto) creditService.createCredit(dto));
    }

    @PostMapping("/professionnel")
    public ResponseEntity<CreditProfessionnelDto> createCreditProfessionnel(@RequestBody CreditProfessionnelDto dto) {
        return ResponseEntity.ok((CreditProfessionnelDto) creditService.createCredit(dto));
    }
}
