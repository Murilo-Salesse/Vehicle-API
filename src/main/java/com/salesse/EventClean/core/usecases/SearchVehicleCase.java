package com.salesse.EventClean.core.usecases;
import com.salesse.EventClean.core.entities.Vehicle;

import java.util.List;

public interface SearchVehicleCase {

    List<Vehicle> execute();
}
