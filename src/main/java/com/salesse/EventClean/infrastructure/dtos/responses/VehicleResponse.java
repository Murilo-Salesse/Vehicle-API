package com.salesse.EventClean.infrastructure.dtos.responses;

import java.math.BigDecimal;

public record VehicleResponse(
    Long id,
    String plate,
    String model,
    String color,
    String chassis,
    Integer year,
    BigDecimal price
) {
}
