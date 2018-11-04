package com.teamone.ui;

import com.teamone.app.*;
import com.teamone.db.ExceptionDBLayer;
import com.teamone.db.VehicleFacade;

import java.util.ArrayList;
import java.util.Objects;

class Menu {
    private Keyboard keyboard = new Keyboard();

    int showChoices() throws Exception {
        int choice;
        Keyboard keyboard = new Keyboard();

        do {
            System.out.println("---Select Functionality to perform:");
            System.out.println("*1 Vehicle Isurance Status ");
            System.out.println("*2 Forecoming Expires ");
            System.out.println("*3 Calculation of total fine cost ");
            choice = Integer.parseInt(keyboard.readFromTheKeyboard());
        } while (choice != 1 && choice != 2 && choice != 3);

        return choice;
    }

    void firstChoise(VehicleFacade vehicleFacade, DateDiffInDays dateDiffInDays) throws ExceptionAppLayer, ExceptionUILayer, ExceptionDBLayer {
        PlateValidation plateValidation = new PlateValidation();
        String plate = plateValidation.validatePlate();
        VehicleState vehicleState=new VehicleState(vehicleFacade,dateDiffInDays);
        System.out.println("The vehicle with the plate " + plate + " is " + vehicleState.getVehicleStatus(plate));
    }

    void secondChoice(VehicleFacade vehicleFacade, DateDiffInDays diffInDays) throws ExceptionUILayer, ExceptionAppLayer {
        System.out.println("Give the time frame in which the expired plates will be found");
        long timeframe = Long.parseLong(keyboard.readFromTheKeyboard());

        ForecomingExpires forecomingExpires = new ForecomingExpires(vehicleFacade,diffInDays);

        ArrayList<Vehicle> vehicleList = forecomingExpires.getVehiclesThatWillBeExpired(timeframe);

        int choice;
        String sortChoice;
        do {
            System.out.print("Would you like to be sorted in alphanumerical order");
            System.out.println(" Y or N ?");
            sortChoice = keyboard.readFromTheKeyboard();
        }while(Objects.equals(sortChoice, "Y") || Objects.equals(sortChoice, "y") ||
                Objects.equals(sortChoice, "N") || Objects.equals(sortChoice, "n"));

        if (Objects.equals(sortChoice, "Y") || Objects.equals(sortChoice, "y")){
            VehicleSorting vehicleSorting = new VehicleSorting();
            vehicleSorting.getUninsuredVehiclesInOrder(vehicleList);
        }

        do {
            System.out.println("---Enter Export Type:");
            System.out.println("*1 File in .csv");
            System.out.println("*2 Console ");
            choice = Integer.parseInt(keyboard.readFromTheKeyboard());
        } while (choice != 1 && choice != 2);

        if (choice == 1) {
            CsvFormat csv = new CsvFormat();
            csv.writeToCsv(vehicleList);
        } else {
            PrintVehicle printVehicle = new PrintVehicle();
            printVehicle.printForecomingExpires(vehicleList);
        }
    }

    void thirdChoice(VehicleFacade vehicleFacade, DateDiffInDays dateDiffInDays) throws ExceptionUILayer, ExceptionAppLayer {
       OwnersUninsured ownersUninsured = new OwnersUninsured(vehicleFacade,dateDiffInDays);
       Fine fine = new Fine();

       System.out.println("Give the owner's name");
       String ownerName = keyboard.readFromTheKeyboard();
       ArrayList<Vehicle> vehicles = ownersUninsured.getOwnersUninsuredVehicles(ownerName);

       if (vehicles.size()<=0){
           System.out.println("It's ok you can go now");
       }else {
           System.out.println("Give the fine in euros: ");
           long fineCost = Long.parseLong(keyboard.readFromTheKeyboard());
           System.out.println(" You have to pay us man :" + fine.calcFine(vehicles, fineCost));
       }
    }

}
