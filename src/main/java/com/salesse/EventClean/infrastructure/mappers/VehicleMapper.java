package com.salesse.EventClean.infrastructure.mappers;

import com.salesse.EventClean.core.entities.Vehicle;
import com.salesse.EventClean.core.usecases.VehicleIdentifierGeneratorCase;
import com.salesse.EventClean.infrastructure.dtos.requests.VehicleRequest;
import com.salesse.EventClean.infrastructure.dtos.responses.VehicleResponse;
import lombok.experimental.UtilityClass;

import java.util.List;


@UtilityClass
public class VehicleMapper {


    // Converte de VehicleDTO (entrada) para VehicleModel (entidade do banco)
    public static Vehicle toVehicleEntity(VehicleRequest vehicleRequest,
                                          String chassis) {

        return new Vehicle(
                null,
                vehicleRequest.plate(),
                vehicleRequest.model(),
                vehicleRequest.color(),
                chassis,
                vehicleRequest.year(),
                vehicleRequest.price()
        );
    }

    // Converte de VehicleModel (entidade do banco) para VehicleDTO (saida)
    public static VehicleResponse toVehicleRequest(Vehicle vehicle) {

        return new VehicleResponse(
                vehicle.id(),
                vehicle.plate(),
                vehicle.model(),
                vehicle.color(),
                vehicle.chassis(),
                vehicle.year(),
                vehicle.price()
        );
    }

    public static List<VehicleResponse> toVehicleRequestList(List<Vehicle> vehicles) {
        return vehicles.stream()
                .map(VehicleMapper::toVehicleRequest)
                .toList();
    }

}
