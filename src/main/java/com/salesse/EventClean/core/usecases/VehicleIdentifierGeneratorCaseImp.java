package com.salesse.EventClean.core.usecases;

import java.util.UUID;

public class VehicleIdentifierGeneratorCaseImp implements VehicleIdentifierGeneratorCase {


    @Override
    public String execute() {
        return "CHS-" + UUID.randomUUID().toString().replace("-", "").substring(0, 14).toUpperCase();
    }
}
