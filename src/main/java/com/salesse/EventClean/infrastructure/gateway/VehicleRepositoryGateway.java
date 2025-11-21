package com.salesse.EventClean.infrastructure.gateway;

import com.salesse.EventClean.core.entities.Vehicle;
import com.salesse.EventClean.core.gateway.VehicleGateway;
import com.salesse.EventClean.infrastructure.mappers.VehicleEntityMapper;
import com.salesse.EventClean.infrastructure.persistence.VehicleEntity;
import com.salesse.EventClean.infrastructure.persistence.VehicleRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class VehicleRepositoryGateway implements VehicleGateway {

    private final VehicleRepository vehicleRepository;

    public VehicleRepositoryGateway(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public Vehicle createVehicle(Vehicle vehicle) {
        VehicleEntity savedEntity = vehicleRepository.save(VehicleEntityMapper.toEntity(vehicle));
        return VehicleEntityMapper.toDomain(savedEntity);
    }

    @Override
    public List<Vehicle> getAllVehicles() {
        List<VehicleEntity> listVehicles = vehicleRepository.findAll();

        return listVehicles.stream()
                .map(VehicleEntityMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Vehicle listById(Long id) {
        VehicleEntity vehicle = vehicleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Veiculo não encontrado"));

        return VehicleEntityMapper.toDomain(vehicle);
    }

    @Override
    public String generateVehicleIdentifier() {
        return "CHS-" + System.currentTimeMillis();
    }


}
