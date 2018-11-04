package com.teamone.app;

import com.teamone.db.VehicleFacade;

import java.util.Date;

public class VehicleState {

    private DateDiffInDays dateDiffInDays;
    private VehicleFacade vehicleFacade;

    public VehicleState(VehicleFacade vehicleFacade, DateDiffInDays dateDiffInDays ){
        this.vehicleFacade = vehicleFacade;
        this.dateDiffInDays = dateDiffInDays;
    }

    public Enum getVehicleStatus(String plate) throws ExceptionAppLayer {
        Enum status;
        Date endDate;

        try {
            endDate = vehicleFacade.getEndDateForVehicle(plate);

            long dateDiff = dateDiffInDays.checkDateDiff(endDate);

            if (dateDiff<=0.0){
                status = VehicleStatus.UNINSURED;
            }else{
                status = VehicleStatus.INSURED;
            }
        } catch (Exception exe) {
            throw new ExceptionAppLayer("Problem in status  !!!", exe);
        }
        return status;
    }

}
