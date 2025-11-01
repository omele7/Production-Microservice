package pe.edu.upc.bovinova.production.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.bovinova.production.domain.model.aggregates.Animal;

public interface AnimalRepository extends JpaRepository<Animal, Long> {

}
