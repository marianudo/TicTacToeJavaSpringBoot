package com.david.tictactoe.model;

public class Tablero {
    // Cuadrícula de 3X3
    private Casilla[][] casillas = new Casilla[3][3];

    /**
     * Creamos un tablero vacío
     */
    public Tablero() {
        for (int i = 0; i < casillas.length ; i++) {
            Casilla[] fila = casillas[i];
            for (int j = 0; j < fila.length; j++) {
                casillas[i][j] = Casilla.VACIA;
            }
        }
    }

    public void colocarFicha(Casilla ficha, int fila, int columna) throws MovimientoNoValidoException {
        validarPosicionTablero(fila, "fila");
        validarPosicionTablero(columna, "columna");

        Casilla casilla = casillas[fila][columna];
        if(casilla != Casilla.VACIA) throw new MovimientoNoValidoException(
                "Casilla ocupada por " + casilla
        );

        casillas[fila][columna] = ficha;
    }

    private void validarPosicionTablero(int posicion, String label) throws MovimientoNoValidoException {
        if(posicion > 2 || posicion < 0) throw new MovimientoNoValidoException(label +
                " no valida (debe ser de 0 a 2, vino " + posicion + ")");
    }

    public Casilla getFicha(int fila, int columna) {
        Casilla contenido = casillas[fila][columna];
        return contenido;
    }
}
