package pe.edu.upc.bovinova.production.domain.model.aggregates;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "productions")
public class Production {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long animalId;

    private String type; // "milk" o "meat"

    private BigDecimal quantity;

    private String unit;

    private LocalDate date;

    private String status; // "IN_PROGRESS", "COMPLETED", "VALIDATED", etc.

    public Production() {}

    public Production(Long animalId, String type, BigDecimal quantity, String unit, LocalDate date, String status) {
        this.animalId = animalId;
        this.type = type;
        this.quantity = quantity;
        this.unit = unit;
        this.date = date;
        this.status = status;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // Marcado como completada
    public void markAsCompleted() {
        this.status = "COMPLETED";
    }

    // Validación de la producción
    public void validateProduction() {
        this.status = "VALIDATED";
    }
}
