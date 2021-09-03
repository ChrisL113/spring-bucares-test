package com.example.nubedianTest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Persistable;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Processor implements Persistable<String> {

    @Id
    private  String model;

    @NotBlank(message = "Brand cannot be empty or null ")
    private String brand;

    @NotBlank(message = "Socket cannot be empty or null ")
    private String socket;

    @NotBlank(message = "ClockSpeed cannot be empty or null ")
    private String clockSpeed;

    private Long numberOfCores;

    private Long numberOfThreads;

    private Double TDP;

    private Double EUR;

    @Transient
    private boolean update;

    @Override
    public String getId() {
        return this.model;
    }

    @Override
    public boolean isNew() {
        return this.update;
    }

    @PrePersist
    @PostLoad
    public void markUpdate() {
        this.update = true;
    }
}
