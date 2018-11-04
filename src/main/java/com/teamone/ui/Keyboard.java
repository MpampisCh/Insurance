package com.teamone.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Keyboard {

    public String readFromTheKeyboard() throws ExceptionUILayer {
        try {
            InputStreamReader reader = new InputStreamReader(System.in);
            BufferedReader bufferedReader = new BufferedReader(reader);
            return(bufferedReader.readLine());

        }catch (IOException exe){
            throw new ExceptionUILayer("Keyboard " , exe);
        }
    }
}
