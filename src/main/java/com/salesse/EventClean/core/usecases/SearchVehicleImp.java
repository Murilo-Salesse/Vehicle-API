package com.salesse.EventClean.core.usecases;

import com.salesse.EventClean.core.entities.Vehicle;
import com.salesse.EventClean.core.gateway.VehicleGateway;
import java.util.List;

public class SearchVehicleImp implements SearchVehicleCase {

    private final VehicleGateway vehicleGateway;

    public SearchVehicleImp(VehicleGateway vehicleGateway) {
        this.vehicleGateway = vehicleGateway;
    }

    @Override
    public List<Vehicle> execute() {
        return vehicleGateway.getAllVehicles();
    }
}
