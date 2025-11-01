package pe.edu.upc.bovinova.production.application.dto;

import pe.edu.upc.bovinova.production.domain.model.aggregates.Production;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ProductionResponse {

    private Long id;
    private Long animalId;
    private String type;
    private BigDecimal quantity;
    private String unit;
    private LocalDate date;
    private String status;

    public ProductionResponse() {}

    public ProductionResponse(Long id, Long animalId, String type, BigDecimal quantity, String unit, LocalDate date, String status) {
        this.id = id;
        this.animalId = animalId;
        this.type = type;
        this.quantity = quantity;
        this.unit = unit;
        this.date = date;
        this.status = status;
    }

    public static ProductionResponse fromEntity(Production p) {
        return new ProductionResponse(
                p.getId(),
                p.getAnimalId(),
                p.getType(),
                p.getQuantity(),
                p.getUnit(),
                p.getDate(),
                p.getStatus()
        );
    }

    // getters y setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getAnimalId() { return animalId; }
    public void setAnimalId(Long animalId) { this.animalId = animalId; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public BigDecimal getQuantity() { return quantity; }
    public void setQuantity(BigDecimal quantity) { this.quantity = quantity; }
    public String getUnit() { return unit; }
    public void setUnit(String unit) { this.unit = unit; }
    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}