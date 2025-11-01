package pe.edu.upc.bovinova.production.application.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upc.bovinova.production.application.dto.CreateProductionRequest;
import pe.edu.upc.bovinova.production.domain.model.aggregates.Production;
import pe.edu.upc.bovinova.production.domain.repository.ProductionRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductionService {

    private final ProductionRepository productionRepository;

    public ProductionService(ProductionRepository productionRepository) {
        this.productionRepository = productionRepository;
    }

    public Production createProduction(CreateProductionRequest request) {
        Production p = new Production(
                request.getAnimalId(),
                request.getType(),
                request.getQuantity(),
                request.getUnit(),
                request.getDate(),
                request.getStatus() == null ? "IN_PROGRESS" : request.getStatus()
        );
        return productionRepository.save(p);
    }

    public Optional<Production> updateProductionStatus(Long productionId, String status) {
        return productionRepository.findById(productionId).map(p -> {
            p.setStatus(status);
            return productionRepository.save(p);
        });
    }

    @Transactional(readOnly = true)
    public List<Production> getProductionHistory(Long animalId, LocalDate start, LocalDate end) {
        if (start != null && end != null) {
            return productionRepository.findByAnimalIdAndDateBetween(animalId, start, end);
        }
        return productionRepository.findByAnimalId(animalId);
    }

    // placeholder para reporte
    @Transactional(readOnly = true)
    public String generatePerformanceReport() {
        // implementación simple: contar registros totales
        long total = productionRepository.count();
        return "Total productions: " + total;
    }
}
