package com.teamone.app;

public class ExceptionAppLayer extends Exception{

    ExceptionAppLayer(String message, Throwable cause){
        super(message,  cause);
    }
}

