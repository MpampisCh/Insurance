package com.teamone.app;

import com.teamone.db.ExceptionDBLayer;
import com.teamone.db.VehicleFacade;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class OwnersUninsured {

    private VehicleFacade vehicleFacade;
    private DateDiffInDays diffInDays;

    public OwnersUninsured(VehicleFacade vehicleFacade, DateDiffInDays dateDiffInDays){
        this.vehicleFacade = vehicleFacade;
        this.diffInDays = dateDiffInDays;
    }

    public ArrayList<Vehicle> getOwnersUninsuredVehicles(String lastName) throws ExceptionAppLayer {

        ArrayList<Vehicle> vehicles;
        try {
            long days;
            vehicles = vehicleFacade.getOwnersVehicles(lastName);
            for (Vehicle vehicle : vehicles) {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date endDate = dateFormat.parse(vehicle.getEndDate());
                days = diffInDays.checkDateDiff(endDate);

                if (days >= 0){
                    vehicles.remove(vehicle);
                }
            }
        } catch (ExceptionDBLayer | ParseException exe) {
            throw new ExceptionAppLayer("Problem in Owners Uninsured Vehicles" , exe);
        }
        return vehicles;
    }

}
