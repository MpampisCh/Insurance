package com.teamone.app;

import java.util.Comparator;

public class VehicleCompare implements Comparator<Vehicle> {

    public int compare(Vehicle vehicle1, Vehicle vehicle2){
        return vehicle1.getPlate().compareTo(vehicle2.getPlate());
    }
}
