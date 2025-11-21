package com.salesse.EventClean.core.entities;
import java.math.BigDecimal;

public record Vehicle(Long id,
    String plate,
    String model,
    String color,
    String chassis,
    Integer year,
    BigDecimal price
  ) {}
