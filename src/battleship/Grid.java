/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package battleship;

import java.util.ArrayList;

/**
 *
 * @autor Nacho Verdón
 *
 * Representa el tablero donde tendrá lugar la partida. Se encarga de manejar
 * todo los relacionado con el tablero y sus 'piezas'.
 *
 * - grid es una lista con las celdas a representar en el tablero.
 * - playerShips es una lista con diferentes barcos. Éstos contienen su
 * localización dentro del tablero.
 * - cpuShips, como playerShips pero los barcos del ordenador.
 * - HEIGHT es la altura del tablero.
 * - WIDTH es la anchura del tablero.
 * - CHAR_WATER representa una casilla vacía.
 * - CHAR_WATER_ATTACKED representa una casilla vacía atacada.
 * - CHAR_SHIP representa una casilla de barco.
 * - CHAR_SHIP_ATTACKED representa una casilla de barco atacada.
 */


public class Grid {
    private final ArrayList<Cell> grid;
    private ArrayList<Ship> playerShips;
    private ArrayList<Ship> cpuShips;
    private final int HEIGHT = 10;
    private final int WIDTH = 10;
    private static final String CHAR_WATER = "≈";
    private static final String CHAR_WATER_ATTACKED = "X";
    private static final String CHAR_SHIP = "◊";
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

    // Muestra el contenido del tablero en forma de cuadrado.
    public final void showGrid() {
        for (int y = 0; y < this.HEIGHT; y++) {
            for (int x = 0; x < this.WIDTH; x++) {
                int cellNumber = y * this.WIDTH + x;
                Cell cell = grid.get(cellNumber);

                // Si la casilla ha sido descubierta
                if (cell.isAttacked()) {
                    
                } else {
                    
                }
                System.out.print("[" + cell.getCharacter() + "]  ");
            }
            System.out.println();
        }
    }


}
