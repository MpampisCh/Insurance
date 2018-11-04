package com.teamone.app;

import com.teamone.ui.ExceptionUILayer;
import com.teamone.ui.Keyboard;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class PlateValidation {

    private boolean checkIfPlateFormatIsRight(String plate) throws ExceptionAppLayer{     // F1

        boolean validation;

        try {
            Matcher m = Pattern.compile("[A-Z][A-Z][A-Z](-)\\d\\d\\d\\d$").matcher(plate);

            if (m.find()) {
                validation = true;
            } else {
                validation = false;
                System.err.println("\nYou provide an unknown pattern!!");
            }

        } catch (PatternSyntaxException exe) {
            throw new ExceptionAppLayer("Problem in PlateFormat" , exe);
        }
        return validation;
    }


    public String validatePlate() throws ExceptionUILayer, ExceptionAppLayer {

        Keyboard read = new Keyboard();

        String plate;
        do {
            System.out.println("Give the plate with format 'ABC-1234'");
            plate = read.readFromTheKeyboard();
        } while (!checkIfPlateFormatIsRight(plate));

        return plate;
    }





}
