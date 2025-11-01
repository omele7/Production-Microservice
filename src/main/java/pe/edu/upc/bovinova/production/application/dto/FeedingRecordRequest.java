package pe.edu.upc.bovinova.production.application.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public class FeedingRecordRequest {

    @NotNull
    private Long animalId;

    @NotBlank
    private String feedType;

    @NotNull
    @DecimalMin("0.0")
    private Double quantity;

    private LocalDateTime recordDate;

    public FeedingRecordRequest() {}

    // getters y setters
    public Long getAnimalId() { return animalId; }
    public void setAnimalId(Long animalId) { this.animalId = animalId; }
    public String getFeedType() { return feedType; }
    public void setFeedType(String feedType) { this.feedType = feedType; }
    public Double getQuantity() { return quantity; }
    public void setQuantity(Double quantity) { this.quantity = quantity; }
    public LocalDateTime getRecordDate() { return recordDate; }
    public void setRecordDate(LocalDateTime recordDate) { this.recordDate = recordDate; }
}