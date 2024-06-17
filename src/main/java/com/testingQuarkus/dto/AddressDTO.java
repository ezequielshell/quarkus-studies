package com.testingQuarkus.dto;

public record AddressDTO(
    Long id,
    String street,
    String city,
    String country
) {}
