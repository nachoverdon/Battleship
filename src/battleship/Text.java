/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship;

/**
 *
 * @author Nacho Verdón
 *
 * Esta clase almacena el texto a mostrar por pantalla. Tenerlo por separado
 * facilita la edición, organización y la traducción.
 */
public class Text {
    // Representa una casilla de barco.
    static final String CHAR_SHIP = "◊";
    // Representa una casilla de barco atacada.
    static final String CHAR_SHIP_ATTACKED = "♦";
    // Representa una casilla vacía.
    static final String CHAR_WATER = "≈";
    // Representa una casilla vacía atacada.
    static final String CHAR_WATER_ATTACKED = "X";
    static final String PLAYER_GRID = "Tablero del jugador";
    static final String CPU_GRID = "Tablero del oponente CPU";
    static final String MISSED = "Fallaste";
    static final String HIT = "Tocado!";
    static final String SANK = "Tocado y hundido!";

    // Exceptions
    public static final String ALREADY_ATTACKED_EX = "Error: Celda ya atacada.";
    public static final String WRONG_SHIP_FILE_EX ="Error en el fichero de " +
        "barcos. Por favor, lee la documentación para saber como rellenar " +
        "correctamente dicho fichero.";
}
