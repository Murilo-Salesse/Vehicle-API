package com.salesse.EventClean.infrastructure.beans;

import com.salesse.EventClean.core.gateway.VehicleGateway;
import com.salesse.EventClean.core.usecases.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public CreateVehicleCase createVehicle(VehicleGateway vehicleGateway) {
        return new CreateVehicleImp(vehicleGateway);
    }

    @Bean
    public SearchVehicleCase searchVehicleCase(VehicleGateway vehicleGateway) {
        return new SearchVehicleImp(vehicleGateway);
    }

    @Bean
    public SearchVehicleByIdCase searchVehicleByIdCase(VehicleGateway vehicleGateway) {
        return new SearchVehicleByIdImp(vehicleGateway);
    }

    @Bean
    public VehicleIdentifierGeneratorCase vehicleIdentifierGeneratorCase() {
        return new VehicleIdentifierGeneratorCaseImp();
    }
}
