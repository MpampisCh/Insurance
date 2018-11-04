package com.teamone.db;

public class ExceptionDBLayer extends Exception{

    ExceptionDBLayer(String message, Throwable cause){
        super(message,  cause);
    }
}
