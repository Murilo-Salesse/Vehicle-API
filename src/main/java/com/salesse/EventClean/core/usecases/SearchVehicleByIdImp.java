package com.salesse.EventClean.core.usecases;
import com.salesse.EventClean.core.entities.Vehicle;
import com.salesse.EventClean.core.gateway.VehicleGateway;

public class SearchVehicleByIdImp implements SearchVehicleByIdCase{

    private final VehicleGateway vehicleGateway;

    public SearchVehicleByIdImp(VehicleGateway vehicleGateway) {
        this.vehicleGateway = vehicleGateway;
    }

    @Override
    public Vehicle execute(Long id) {
        return vehicleGateway.listById(id);
    }
}
