package com.salesse.EventClean.core.usecases;
import com.salesse.EventClean.core.entities.Vehicle;

public interface CreateVehicleCase {

    Vehicle execute(Vehicle vehicle);
}
