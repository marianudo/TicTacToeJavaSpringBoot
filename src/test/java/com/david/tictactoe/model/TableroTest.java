package com.david.tictactoe.model;

import org.junit.Test;
import static org.junit.Assert.*;

public class TableroTest {
    private Tablero tableroInicial = new Tablero();

    // Happy path
    @Test public void testObtenerFichaDeCasillaVacia() {
        Casilla casilla = tableroInicial.getFicha(0, 0);
        assertEquals(Casilla.VACIA, casilla);
    }

    @Test public void testObtenerFichaDeCasillaLlena() throws MovimientoNoValidoException {
        int fila = 0;
        int columna = 0;

        tableroInicial.colocarFicha(Casilla.JUGADOR1, fila, columna);
        assertNotEquals(Casilla.VACIA, tableroInicial.getFicha(fila, columna));
    }

    // Errores
    @Test(expected = MovimientoNoValidoException.class)
    public void posicionarFichaEnFilaFueraDelTablero() throws MovimientoNoValidoException {
        int fila = 3;
        int columna = 0;
        tableroInicial.colocarFicha(Casilla.JUGADOR1, fila, columna);
    }

    @Test(expected = MovimientoNoValidoException.class)
    public void posicionarFichaEnColumnaFueraDelTablero() throws MovimientoNoValidoException {
        int fila = 0;
        int columna = 3;
        tableroInicial.colocarFicha(Casilla.JUGADOR1, fila, columna);
    }

    @Test(expected = MovimientoNoValidoException.class)
    public void posicionarFichaEnCasillaOcupadaPorMi() throws MovimientoNoValidoException {
        int filaJ1 = 0;
        int colJ1 = 0;
        tableroInicial.colocarFicha(Casilla.JUGADOR1, filaJ1, colJ1);
        tableroInicial.colocarFicha(Casilla.JUGADOR1, filaJ1, colJ1);
    }

    @Test(expected = MovimientoNoValidoException.class)
    public void posicionarFichaEnCasillaOcupadaPorOtro() throws MovimientoNoValidoException {
        int filaJ1 = 0;
        int colJ1 = 0;
        tableroInicial.colocarFicha(Casilla.JUGADOR2, filaJ1, colJ1);
        tableroInicial.colocarFicha(Casilla.JUGADOR1, filaJ1, colJ1);
    }
}
