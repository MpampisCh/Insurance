package com.teamone.app;

import java.util.ArrayList;

public class VehicleSorting {
    public ArrayList<Vehicle> getUninsuredVehiclesInOrder(ArrayList<Vehicle> Vehicles){
        VehicleCompare vehicleCompare= new VehicleCompare();
        Vehicles.sort(vehicleCompare);
        return(Vehicles);
    }
}
