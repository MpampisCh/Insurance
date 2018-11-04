package com.teamone.app;

import java.util.ArrayList;

public class Fine {

    public long calcFine(ArrayList<Vehicle> vehicles, long fine){
        return fine * vehicles.size();
    }
}
