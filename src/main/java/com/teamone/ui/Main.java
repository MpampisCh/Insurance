package com.teamone.ui;


import com.teamone.app.DateDiffInDays;
import com.teamone.db.ConnectionDB;
import com.teamone.db.VehicleFacade;

public class Main {
    public static void main(String[] args) throws Exception {

        Menu menu = new Menu();

        ConnectionDB connectionDB = new ConnectionDB();
        VehicleFacade vehicleFacade = new VehicleFacade(connectionDB);
        DateDiffInDays dateDiffInDays = new DateDiffInDays();

        switch (menu.showChoices()) {
            case 1:
                menu.firstChoise(vehicleFacade, dateDiffInDays);
                break;

            case 2:
                menu.secondChoice(vehicleFacade, dateDiffInDays);

                break;

            case 3:
                menu.thirdChoice(vehicleFacade, dateDiffInDays);
                break;
        }
    }

}
