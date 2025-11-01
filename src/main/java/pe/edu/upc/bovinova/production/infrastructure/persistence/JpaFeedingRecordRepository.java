package pe.edu.upc.bovinova.production.infrastructure.persistence;

import org.springframework.stereotype.Repository;
import pe.edu.upc.bovinova.production.domain.model.aggregates.FeedingRecord;
import pe.edu.upc.bovinova.production.domain.repository.FeedingRecordRepository;

import java.util.List;
import java.util.Optional;

@Repository
public class JpaFeedingRecordRepository {

    private final FeedingRecordRepository feedingRecordRepository;

    public JpaFeedingRecordRepository(FeedingRecordRepository feedingRecordRepository) {
        this.feedingRecordRepository = feedingRecordRepository;
    }

    public FeedingRecord save(FeedingRecord record) {
        return feedingRecordRepository.save(record);
    }

    public Optional<FeedingRecord> findById(Long id) {
        return feedingRecordRepository.findById(id);
    }

    public List<FeedingRecord> findByAnimalId(Long animalId) {
        return feedingRecordRepository.findByAnimalId(animalId);
    }

    public void deleteById(Long id) {
        feedingRecordRepository.deleteById(id);
    }
}