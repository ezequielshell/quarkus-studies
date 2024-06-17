package com.testingQuarkus.dto;

public record PersonDTO(
    Long id,
    String name,
    int age
    ) {
}
