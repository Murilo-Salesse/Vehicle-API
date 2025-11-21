package com.salesse.EventClean.core.gateway;
import com.salesse.EventClean.core.entities.Vehicle;
import java.util.List;

public interface VehicleGateway {

    public Vehicle createVehicle(Vehicle vehicle);
    public List<Vehicle> getAllVehicles();
    public Vehicle listById(Long id);
    public String generateVehicleIdentifier();
}
