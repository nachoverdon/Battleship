/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package battleship;

import battleship.Exceptions.*;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @autor Nacho Verdón
 *
 * Representa el tablero donde tendrá lugar la partida. Se encarga de manejar
 * todo los relacionado con el tablero y sus 'piezas'.
 *
 */


public class Grid {
    // Lista con las celdas a representar en el tablero.
    private final ArrayList<Cell> grid;
    // Lista con diferentes barcos. Éstos contienen su localización dentro del
    // tablero.
    private ArrayList<Ship> playerShips;
    // Como playerShips pero los barcos del tablero del oponente CPU.
    private ArrayList<Ship> cpuShips;
    // La altura del tablero.
    private final int HEIGHT = 10;
    // La anchura del tablero.
    private final int WIDTH = 10;
    // Representa una casilla vacía.
    private static final String CHAR_WATER = "≈";
    // Representa una casilla vacía atacada.
    private static final String CHAR_WATER_ATTACKED = "X";
    // Representa una casilla de barco.
    private static final String CHAR_SHIP = "◊";
    // Representa una casilla de barco atacada.
    private static final String CHAR_SHIP_ATTACKED = "♦";

    public Grid() {
        this.grid = new ArrayList<>();
        this.fillGrid();
        this.showGrid();

    }

    private void placeShips() {
        
    }

    // TEST: Método para comprobar salidas de rango
    public String getByIndexTest(int idx) {
        return grid.get(idx).getCharacter();
    }

    // Rellena el tablero con 'nada' para su presentación visual.
    private void fillGrid() {
        for (int y = 0; y < (this.HEIGHT * this.WIDTH); y++) {
            Cell waterCell = new Cell(Grid.CHAR_WATER, Grid.CHAR_WATER_ATTACKED);
            grid.add(waterCell);
        }
    }

    // Muestra el contenido real del tablero en forma de cuadrado.
    private void showRealGrid() {
        for (int y = 0; y < this.HEIGHT; y++) {
            for (int x = 0; x < this.WIDTH; x++) {
                System.out.print(grid.get(y * this.WIDTH + x) + " ");
            }
            System.out.println();
        }
    }

    /**
     * @return El contenido del tablero separado por lineas del tamaño del
     * WIDTH.
     */
    public final String showGrid() {
        String gridText = "";
        for (int y = 0; y < this.HEIGHT; y++) {
            for (int x = 0; x < this.WIDTH; x++) {
                int cellNumber = y * this.WIDTH + x;
                Cell cell = this.grid.get(cellNumber);
                gridText += "[" + cell.getCharacter() + "]  ";
            }
            gridText += "\n";
        }
        return gridText;
    }

    /**
     * Marca como atacada la casilla de la posición dada.
     *
     * @param index Índice de la casilla en el grid.
     * @return El caracter de la casilla que ha atacado.
     * @throws Exception Si la casilla ya ha sido atacada previamente.
     */
    public final String attackCell(int index) throws Exception {
        // Si ya ha sido atacada, lanza una excepción
        if (this.grid.get(index).isAttacked()) {
            throw new AlreadyAttackedException();
        }
        return "";
    }


}
