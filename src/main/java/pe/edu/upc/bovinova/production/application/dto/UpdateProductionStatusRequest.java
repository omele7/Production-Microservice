package pe.edu.upc.bovinova.production.application.dto;

import jakarta.validation.constraints.NotBlank;

public class UpdateProductionStatusRequest {

    @NotBlank
    private String status;

    public UpdateProductionStatusRequest() {}

    public UpdateProductionStatusRequest(String status) {
        this.status = status;
    }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}