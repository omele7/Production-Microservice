package pe.edu.upc.bovinova.production.domain.model.aggregates;

import jakarta.persistence.*;

@Entity
@Table(name = "animals")
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tagNumber;

    private String name;

    private String breed;

    private Integer age;

    private Double weight;

    public Animal() {}

    public Animal(String tagNumber, String name, String breed, Integer age, Double weight) {
        this.tagNumber = tagNumber;
        this.name = name;
        this.breed = breed;
        this.age = age;
        this.weight = weight;
    }

    public Long getId() {
        return id;
    }

    public String getTagNumber() {
        return tagNumber;
    }

    public void setTagNumber(String tagNumber) {
        this.tagNumber = tagNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    // Actualiza el peso del animal
    public void updateWeight(Double newWeight) {
        this.weight = newWeight;
    }

    // Asignación genérica a producción (placeholder para lógica de dominio)
    public void assignToProduction(Long productionId) {
        // lógica de dominio si fuera necesaria (p.ej. registrar relación)
    }
}
