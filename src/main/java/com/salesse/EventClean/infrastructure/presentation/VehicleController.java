package com.salesse.EventClean.infrastructure.presentation;

import com.salesse.EventClean.core.entities.Vehicle;
import com.salesse.EventClean.core.usecases.CreateVehicleCase;
import com.salesse.EventClean.core.usecases.SearchVehicleByIdCase;
import com.salesse.EventClean.core.usecases.SearchVehicleCase;
import com.salesse.EventClean.core.usecases.VehicleIdentifierGeneratorCase;
import com.salesse.EventClean.infrastructure.dtos.requests.VehicleRequest;
import com.salesse.EventClean.infrastructure.dtos.responses.VehicleResponse;
import com.salesse.EventClean.infrastructure.mappers.VehicleMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    private final CreateVehicleCase createVehicleCase;
    private final SearchVehicleCase searchVehicleCase;
    private final SearchVehicleByIdCase searchVehicleByIdCase;
    private final VehicleIdentifierGeneratorCase vehicleIdentifierGeneratorCase;


    public VehicleController(CreateVehicleCase createVehicleCase, SearchVehicleCase searchVehicleCase, SearchVehicleByIdCase searchVehicleByIdCase, VehicleIdentifierGeneratorCase vehicleIdentifierGeneratorCase, VehicleIdentifierGeneratorCase vehicleIdentifierGeneratorCase1) {
        this.createVehicleCase = createVehicleCase;
        this.searchVehicleCase = searchVehicleCase;
        this.searchVehicleByIdCase = searchVehicleByIdCase;
        this.vehicleIdentifierGeneratorCase = vehicleIdentifierGeneratorCase;
    }

    @PostMapping("/create")
    public ResponseEntity<Map<String, Object>> createVehicle(@RequestBody VehicleRequest vehicle) {
        String chassis = vehicleIdentifierGeneratorCase.execute();
        Vehicle newVehicle = createVehicleCase.execute(VehicleMapper.toVehicleEntity(vehicle, chassis));

        Map<String, Object> response = Map.of(
                "message", "Vehicle created successfully",
                "vehicle", VehicleMapper.toVehicleRequest(newVehicle)
        );

        return ResponseEntity.ok(response);


//        Map<String, Object> response2 = new HashMap<>();
//        response2.put("Message: ", "Vehicle created successfully");
//        response2.put("Vehicle: ", VehicleMapper.toVehicleRequest(newVehicle));
//        return ResponseEntity.ok(response2);

    }

    @GetMapping("/status")
    public ResponseEntity<Map<String, Object>> listAll() {
        List<Vehicle> vehicles = searchVehicleCase.execute();

        Map<String, Object> response = Map.of(
                "message", "Vehicles retrieved successfully",
                "vehicle", VehicleMapper.toVehicleRequestList(vehicles));

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> listById(@PathVariable("id") Long id){
        Vehicle vehicle = searchVehicleByIdCase.execute(id);

        Map<String, Object> response = Map.of(
                "message", "Vehicle retrieved successfully",
                "vehicle", VehicleMapper.toVehicleRequest(vehicle)
        );

        return ResponseEntity.ok(response);
    }
}
