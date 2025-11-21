package com.salesse.EventClean.infrastructure.dtos.requests;

import java.math.BigDecimal;

public record VehicleRequest(
    String plate,
    String model,
    String color,
    Integer year,
    BigDecimal price
) {
}
