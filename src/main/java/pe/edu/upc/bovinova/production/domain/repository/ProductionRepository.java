package pe.edu.upc.bovinova.production.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.bovinova.production.domain.model.aggregates.Production;

import java.time.LocalDate;
import java.util.List;

public interface ProductionRepository extends JpaRepository<Production, Long> {
    List<Production> findByAnimalId(Long animalId);
    List<Production> findByAnimalIdAndDateBetween(Long animalId, LocalDate start, LocalDate end);
}