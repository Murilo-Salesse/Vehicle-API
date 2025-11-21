package com.salesse.EventClean.core.usecases;
import com.salesse.EventClean.core.entities.Vehicle;
import com.salesse.EventClean.core.gateway.VehicleGateway;

public class CreateVehicleImp implements CreateVehicleCase {

    private final VehicleGateway vehicleGateway;

    public CreateVehicleImp(VehicleGateway vehicleGateway) {
        this.vehicleGateway = vehicleGateway;
    }

    @Override
    public Vehicle execute(Vehicle vehicle) {
        return vehicleGateway.createVehicle(vehicle);
    }
}
