package pe.edu.upc.bovinova.production.interfaces.rest;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.bovinova.production.application.dto.CreateProductionRequest;
import pe.edu.upc.bovinova.production.application.service.ProductionService;
import pe.edu.upc.bovinova.production.domain.model.aggregates.Production;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/production")
public class ProductionController {

    private final ProductionService productionService;

    public ProductionController(ProductionService productionService) {
        this.productionService = productionService;
    }

    @PostMapping
    public ResponseEntity<Production> createProduction(@Valid @RequestBody CreateProductionRequest request) {
        Production created = productionService.createProduction(request);
        return ResponseEntity.status(201).body(created);
    }

    @GetMapping("/history")
    public ResponseEntity<List<Production>> getHistory(
            @RequestParam Long animalId,
            @RequestParam(required = false) LocalDate start,
            @RequestParam(required = false) LocalDate end) {
        List<Production> list = productionService.getProductionHistory(animalId, start, end);
        return ResponseEntity.ok(list);
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<Production> updateStatus(@PathVariable Long id, @RequestParam String status) {
        return productionService.updateProductionStatus(id, status)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
