package com.david.tictactoe.model;

public class MovimientoNoValidoException extends Exception {
    public MovimientoNoValidoException(String mensaje) {
        super(mensaje);
    }
}
