package com.salesse.EventClean.infrastructure.mappers;

import com.salesse.EventClean.core.entities.Vehicle;
import com.salesse.EventClean.infrastructure.persistence.VehicleEntity;
import lombok.experimental.UtilityClass;

@UtilityClass
public class VehicleEntityMapper {

    // Converte de VehicleEntity (entrada) para VehicleModel (entidade do banco)
    public static VehicleEntity toEntity(Vehicle vehicle) {

        return new VehicleEntity(
                vehicle.id(),
                vehicle.plate(),
                vehicle.model(),
                vehicle.color(),
                vehicle.chassis(),
                vehicle.year(),
                vehicle.price()
        );
    }

    // Converte de Vechile (entidade do banco) para VehicleEntity (saida)
    public static Vehicle toDomain(VehicleEntity vehicleEntity) {

        return new Vehicle(
                vehicleEntity.getId(),
                vehicleEntity.getPlate(),
                vehicleEntity.getModel(),
                vehicleEntity.getColor(),
                vehicleEntity.getChassis(),
                vehicleEntity.getYear(),
                vehicleEntity.getPrice()
        );
    }

}
