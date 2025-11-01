package pe.edu.upc.bovinova.production.infrastructure.persistence;

import org.springframework.stereotype.Repository;
import pe.edu.upc.bovinova.production.domain.model.aggregates.Animal;
import pe.edu.upc.bovinova.production.domain.repository.AnimalRepository;

import java.util.List;
import java.util.Optional;

@Repository
public class JpaAnimalRepository {

    private final AnimalRepository animalRepository;

    public JpaAnimalRepository(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    public Animal save(Animal animal) {
        return animalRepository.save(animal);
    }

    public Optional<Animal> findById(Long id) {
        return animalRepository.findById(id);
    }

    public List<Animal> findAll() {
        return animalRepository.findAll();
    }

    public void deleteById(Long id) {
        animalRepository.deleteById(id);
    }
}