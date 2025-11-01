package pe.edu.upc.bovinova.production.domain.model.aggregates;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "feeding_records")
public class FeedingRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long animalId;

    private String feedType;

    private Double quantity;

    private LocalDateTime recordDate;

    public FeedingRecord() {}

    public FeedingRecord(Long animalId, String feedType, Double quantity, LocalDateTime recordDate) {
        this.animalId = animalId;
        this.feedType = feedType;
        this.quantity = quantity;
        this.recordDate = recordDate;
    }

    public Long getId() {
        return id;
    }

    public Long getAnimalId() {
        return animalId;
    }

    public void setAnimalId(Long animalId) {
        this.animalId = animalId;
    }

    public String getFeedType() {
        return feedType;
    }

    public void setFeedType(String feedType) {
        this.feedType = feedType;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public LocalDateTime getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(LocalDateTime recordDate) {
        this.recordDate = recordDate;
    }

    // Registrar alimentación: si no tiene fecha, la asigna ahora
    public void registerFeeding() {
        if (this.recordDate == null) {
            this.recordDate = LocalDateTime.now();
        }
    }
}