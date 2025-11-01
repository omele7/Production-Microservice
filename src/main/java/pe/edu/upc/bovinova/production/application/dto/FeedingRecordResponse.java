package pe.edu.upc.bovinova.production.application.dto;

import pe.edu.upc.bovinova.production.domain.model.aggregates.FeedingRecord;

import java.time.LocalDateTime;

public class FeedingRecordResponse {

    private Long id;
    private Long animalId;
    private String feedType;
    private Double quantity;
    private LocalDateTime recordDate;

    public FeedingRecordResponse() {}

    public FeedingRecordResponse(Long id, Long animalId, String feedType, Double quantity, LocalDateTime recordDate) {
        this.id = id;
        this.animalId = animalId;
        this.feedType = feedType;
        this.quantity = quantity;
        this.recordDate = recordDate;
    }

    public static FeedingRecordResponse fromEntity(FeedingRecord e) {
        return new FeedingRecordResponse(
                e.getId(),
                e.getAnimalId(),
                e.getFeedType(),
                e.getQuantity(),
                e.getRecordDate()
        );
    }

    // getters y setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getAnimalId() { return animalId; }
    public void setAnimalId(Long animalId) { this.animalId = animalId; }
    public String getFeedType() { return feedType; }
    public void setFeedType(String feedType) { this.feedType = feedType; }
    public Double getQuantity() { return quantity; }
    public void setQuantity(Double quantity) { this.quantity = quantity; }
    public LocalDateTime getRecordDate() { return recordDate; }
    public void setRecordDate(LocalDateTime recordDate) { this.recordDate = recordDate; }
}