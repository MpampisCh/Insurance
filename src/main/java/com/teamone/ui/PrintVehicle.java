package com.teamone.ui;

import com.teamone.app.Vehicle;

import java.util.ArrayList;

class PrintVehicle {

    void printForecomingExpires(ArrayList<Vehicle> vehicleList){
        for (Vehicle vehicle : vehicleList) {
            System.out.println("The vehicle " +vehicle.getPlate()+ " will be expired at " + vehicle.getEndDate());
        }
    }
}
