package pe.edu.upc.bovinova.production.infrastructure.persistence;

import org.springframework.stereotype.Repository;
import pe.edu.upc.bovinova.production.domain.model.aggregates.Production;
import pe.edu.upc.bovinova.production.domain.repository.ProductionRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public class JpaProductionRepository {

    private final ProductionRepository productionRepository;

    public JpaProductionRepository(ProductionRepository productionRepository) {
        this.productionRepository = productionRepository;
    }

    public Production save(Production production) {
        return productionRepository.save(production);
    }

    public Optional<Production> findById(Long id) {
        return productionRepository.findById(id);
    }

    public List<Production> findByAnimalId(Long animalId) {
        return productionRepository.findByAnimalId(animalId);
    }

    public List<Production> findByAnimalIdAndDateBetween(Long animalId, LocalDate start, LocalDate end) {
        return productionRepository.findByAnimalIdAndDateBetween(animalId, start, end);
    }

    public long count() {
        return productionRepository.count();
    }

    public void deleteById(Long id) {
        productionRepository.deleteById(id);
    }
}
