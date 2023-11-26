package com.david.tictactoe.model;

import org.junit.Test;
import static org.junit.Assert.*;
import static com.david.tictactoe.model.Casilla.*; // Reducir boilerplate code

public class TableroTest {
    private Tablero tableroInicial = new Tablero();

    // Happy path
    @Test public void testObtenerFichaDeCasillaVacia() {
        Casilla casilla = tableroInicial.getFicha(0, 0);
        assertEquals(VACIA, casilla);
    }

    @Test public void testObtenerFichaDeCasillaLlena() throws MovimientoNoValidoException {
        int fila = 0;
        int columna = 0;

        tableroInicial.colocarFicha(JUGADOR1, fila, columna);
        assertNotEquals(VACIA, tableroInicial.getFicha(fila, columna));
    }

    // Errores
    @Test(expected = MovimientoNoValidoException.class)
    public void posicionarFichaEnFilaFueraDelTablero() throws MovimientoNoValidoException {
        int fila = 3;
        int columna = 0;
        tableroInicial.colocarFicha(JUGADOR1, fila, columna);
    }

    @Test(expected = MovimientoNoValidoException.class)
    public void posicionarFichaEnColumnaFueraDelTablero() throws MovimientoNoValidoException {
        int fila = 0;
        int columna = 3;
        tableroInicial.colocarFicha(JUGADOR1, fila, columna);
    }

    @Test(expected = MovimientoNoValidoException.class)
    public void posicionarFichaEnCasillaOcupadaPorMi() throws MovimientoNoValidoException {
        int filaJ1 = 0;
        int colJ1 = 0;
        tableroInicial.colocarFicha(JUGADOR1, filaJ1, colJ1);
        tableroInicial.colocarFicha(JUGADOR1, filaJ1, colJ1);
    }

    @Test(expected = MovimientoNoValidoException.class)
    public void posicionarFichaEnCasillaOcupadaPorOtro() throws MovimientoNoValidoException {
        int filaJ1 = 0;
        int colJ1 = 0;
        tableroInicial.colocarFicha(JUGADOR2, filaJ1, colJ1);
        tableroInicial.colocarFicha(JUGADOR1, filaJ1, colJ1);
    }

    // Tests relacionados con el estado de la partida
    @Test public void testEstadoPartidaConTableroVacio() {
        assertEquals(EstadoPartida.EN_CURSO, tableroInicial.estadoPartida());
    }

    @Test public void testEstadoPartidaConUnaSolaFicha() throws MovimientoNoValidoException {
        tableroInicial.colocarFicha(JUGADOR1, 0, 0);
        assertEquals(EstadoPartida.EN_CURSO, tableroInicial.estadoPartida());
    }

    @Test public void testEstadoPartidaConUnaFichaDeCadaJugador() throws MovimientoNoValidoException {
        tableroInicial.colocarFicha(JUGADOR1, 0, 0);
        tableroInicial.colocarFicha(JUGADOR2, 1, 0);
        assertEquals(EstadoPartida.EN_CURSO, tableroInicial.estadoPartida());
    }

    @Test public void testEstadoPartidaEnCursoYaAvanzada() throws MovimientoNoValidoException {
        tableroInicial.colocarFicha(JUGADOR1, 0, 0);
        tableroInicial.colocarFicha(JUGADOR1, 0, 1);
        tableroInicial.colocarFicha(JUGADOR2, 0, 2);
        tableroInicial.colocarFicha(JUGADOR2, 1, 0);
        tableroInicial.colocarFicha(JUGADOR2, 1, 1);
        tableroInicial.colocarFicha(JUGADOR1, 2, 0);
        assertEquals(EstadoPartida.EN_CURSO, tableroInicial.estadoPartida());
    }

    @Test public void testEstadoPartidaEnTablas() throws MovimientoNoValidoException {
        tableroInicial.colocarFicha(JUGADOR1, 0, 0);
        tableroInicial.colocarFicha(JUGADOR1, 0, 1);
        tableroInicial.colocarFicha(JUGADOR2, 0, 2);
        tableroInicial.colocarFicha(JUGADOR2, 1, 0);
        tableroInicial.colocarFicha(JUGADOR2, 1, 1);
        tableroInicial.colocarFicha(JUGADOR1, 2, 0);
        tableroInicial.colocarFicha(JUGADOR1, 1, 2);
        assertEquals(EstadoPartida.TABLAS, tableroInicial.estadoPartida());
    }
    
    @Test public void testGanaJugador1() throws MovimientoNoValidoException {
        tableroInicial.colocarFicha(JUGADOR1, 0, 0);
        tableroInicial.colocarFicha(JUGADOR2, 0, 1);
        tableroInicial.colocarFicha(JUGADOR1, 1, 0);
        tableroInicial.colocarFicha(JUGADOR1, 1, 1);
        tableroInicial.colocarFicha(JUGADOR2, 2, 0);
        tableroInicial.colocarFicha(JUGADOR2, 2, 2);
        tableroInicial.colocarFicha(JUGADOR1, 1, 2);
        assertEquals(EstadoPartida.GANA_JUGADOR1, tableroInicial.estadoPartida());
    }

    @Test public void testGanaJugador2() throws MovimientoNoValidoException {
        //TODO Tarea para David, implementar este test antes de crear la lógica del método Tablero.estadoPartida()
        fail("Pendiente de implementar");
    }
}
