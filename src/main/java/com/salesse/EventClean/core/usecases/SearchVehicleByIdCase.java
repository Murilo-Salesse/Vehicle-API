package com.salesse.EventClean.core.usecases;
import com.salesse.EventClean.core.entities.Vehicle;

public interface SearchVehicleByIdCase {

    Vehicle execute(Long id);
}
