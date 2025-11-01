package pe.edu.upc.bovinova.production.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.bovinova.production.domain.model.aggregates.FeedingRecord;

import java.util.List;

public interface FeedingRecordRepository extends JpaRepository<FeedingRecord, Long> {
    List<FeedingRecord> findByAnimalId(Long animalId);
}