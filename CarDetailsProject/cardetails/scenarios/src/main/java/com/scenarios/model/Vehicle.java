package com.scenarios.model;

import java.util.HashMap;
import java.util.Map;

public class Vehicle {
    private Map<String, String> details = new HashMap<>();

    public Vehicle(String registrationNumber, String make, String colour) {
        details.put("Registration number", registrationNumber);
        details.put("make", make);
        details.put("colour", colour);
    }

    public Vehicle(Map<String, String> details) {
        this.details = details;
    }

    public Map<String, String> getVehicleDetails() {
        return details;
    }

    public boolean compare(Vehicle other) {
        return details.get("Registration number").equals(other.details.get("Registration number"))
                && details.get("make").equals(other.details.get("make"))
                && details.get("colour").equals(other.details.get("colour"));
    }

    public static Vehicle createVehicle(String registrationNumber, String make, String colour) {
        return new Vehicle(registrationNumber, make, colour);
    }

}
