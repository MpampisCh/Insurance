package com.teamone.app;

import com.teamone.db.ExceptionDBLayer;
import com.teamone.db.VehicleFacade;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ForecomingExpires {

    private VehicleFacade vehicleFacade;
    private DateDiffInDays diffInDays;


    public ForecomingExpires(VehicleFacade vehicleFacade, DateDiffInDays diffInDays) {
        this.vehicleFacade = vehicleFacade;
        this.diffInDays = diffInDays;

    }

    public ArrayList<Vehicle> getVehiclesThatWillBeExpired(long timeframe) throws ExceptionAppLayer {
        ArrayList<Vehicle> expiredVehicle = new ArrayList<>();

        try {
            ArrayList<Vehicle> vehicles = vehicleFacade.getVehiclesList();

            for (Vehicle vehicle : vehicles) {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date endDate = dateFormat.parse(vehicle.getEndDate());
                long days = diffInDays.checkDateDiff(endDate);

                if (days <= timeframe && days >= 0) {
                    expiredVehicle.add(vehicle);
                }
            }
            return expiredVehicle;
        } catch (ExceptionDBLayer | ParseException exe) {
            throw new ExceptionAppLayer("ForecomingExpires getVehiclesThatWillBeExpired" , exe);
        }
    }
}
