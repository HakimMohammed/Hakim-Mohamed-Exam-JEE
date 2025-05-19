package mohamed.hakim.backend.controllers;

import mohamed.hakim.backend.dtos.RemboursementDto;
import mohamed.hakim.backend.services.RemboursementService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/remboursements")
public class RemboursementController {

    private final RemboursementService remboursementService;

    public RemboursementController(RemboursementService remboursementService) {
        this.remboursementService = remboursementService;
    }

    @GetMapping
    public ResponseEntity<List<RemboursementDto>> getAllRemboursements() {
        return ResponseEntity.ok(remboursementService.getAllRemboursements());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RemboursementDto> getRemboursementById(@PathVariable Long id) {
        return ResponseEntity.ok(remboursementService.getRemboursementById(id));
    }

    @PostMapping
    public ResponseEntity<RemboursementDto> createRemboursement(@RequestBody RemboursementDto dto) {
        return ResponseEntity.ok(remboursementService.createRemboursement(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RemboursementDto> updateRemboursement(@PathVariable Long id, @RequestBody RemboursementDto dto) {
        return ResponseEntity.ok(remboursementService.updateRemboursement(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRemboursement(@PathVariable Long id) {
        remboursementService.deleteRemboursement(id);
        return ResponseEntity.noContent().build();
    }
}