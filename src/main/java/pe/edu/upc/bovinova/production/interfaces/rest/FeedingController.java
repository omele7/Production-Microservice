package pe.edu.upc.bovinova.production.interfaces.rest;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.bovinova.production.domain.model.aggregates.FeedingRecord;
import pe.edu.upc.bovinova.production.domain.repository.FeedingRecordRepository;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/feeding")
public class FeedingController {

    private final FeedingRecordRepository feedingRecordRepository;

    public FeedingController(FeedingRecordRepository feedingRecordRepository) {
        this.feedingRecordRepository = feedingRecordRepository;
    }

    @PostMapping
    public ResponseEntity<FeedingRecord> registerFeeding(@Valid @RequestBody FeedingRecord record) {
        if (record.getRecordDate() == null) {
            record.setRecordDate(LocalDateTime.now());
        }
        FeedingRecord saved = feedingRecordRepository.save(record);
        return ResponseEntity.status(201).body(saved);
    }

    @GetMapping("/animal/{id}")
    public ResponseEntity<List<FeedingRecord>> getByAnimal(@PathVariable Long id) {
        List<FeedingRecord> records = feedingRecordRepository.findByAnimalId(id);
        return ResponseEntity.ok(records);
    }
}