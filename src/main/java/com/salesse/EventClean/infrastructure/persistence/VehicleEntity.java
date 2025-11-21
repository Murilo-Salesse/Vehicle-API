package com.salesse.EventClean.infrastructure.persistence;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "vehicles")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class VehicleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String plate;
    private String model;
    private String color;
    private String chassis;
    private Integer year;
    private BigDecimal price;
}