package com.example.nubedianTest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProcessorDto {
    private String model;

    private String brand;

    private String socket;

    private String clockSpeed;

    private Long numberOfCores;

    private Long numberOfThreads;

    private Double TDP;

    private Double EUR;
}
