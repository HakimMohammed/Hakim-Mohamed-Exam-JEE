package mohamed.hakim.backend.controllers;

import mohamed.hakim.backend.dtos.RemboursementDto;
import mohamed.hakim.backend.services.RemboursementService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @PreAuthorize("hasAuthority('SCOPE_USER')")
    public ResponseEntity<List<RemboursementDto>> getAllRemboursements() {
        return ResponseEntity.ok(remboursementService.getAllRemboursements());
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('SCOPE_USER')")
    public ResponseEntity<RemboursementDto> getRemboursementById(@PathVariable Long id) {
        return ResponseEntity.ok(remboursementService.getRemboursementById(id));
    }

    @PostMapping
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    public ResponseEntity<RemboursementDto> createRemboursement(@RequestBody RemboursementDto dto) {
        return ResponseEntity.ok(remboursementService.createRemboursement(dto));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    public ResponseEntity<RemboursementDto> updateRemboursement(@PathVariable Long id, @RequestBody RemboursementDto dto) {
        return ResponseEntity.ok(remboursementService.updateRemboursement(id, dto));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    public ResponseEntity<Void> deleteRemboursement(@PathVariable Long id) {
        remboursementService.deleteRemboursement(id);
        return ResponseEntity.noContent().build();
    }
}