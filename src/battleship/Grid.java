/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package battleship;

import battleship.Exceptions.*;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;

/**
 *
 * @autor Nacho Verdón
 *
 * Representa el tablero donde tendrá lugar la partida. Se encarga de manejar
 * todo los relacionado con el tablero y sus 'piezas'.
 *
 */


public class Grid implements WaterCharacters {
    // Habilita las opciones de dugging y testeos si es true
    private final boolean DEBUG = false;
    // Ruta del archivo con la posición de los barcos del jugador
    private final String PATH = "src/ships.grid";
    // Lista con las celdas a representar en el tablero.
    private final ArrayList<Cell> grid;
    // Lista con diferentes barcos. Éstos contienen su localización dentro del
    // tablero.
    private ArrayList<ShipParts> playerShips;
    // Como playerShips pero los barcos del tablero del oponente CPU.
    private ArrayList<ShipParts> cpuShips;
    // La altura del tablero.
    private final int HEIGHT = 10;
    // La anchura del tablero.
    private final int WIDTH = 10;
//    // Representa una casilla vacía.
//    private static final String CHAR_WATER = "≈";
//    // Representa una casilla vacía atacada.
//    private static final String CHAR_WATER_ATTACKED = "X";
//    // Representa una casilla de barco.
//    private static final String CHAR_SHIP = "◊";
//    // Representa una casilla de barco atacada.
//    private static final String CHAR_SHIP_ATTACKED = "♦";

    public Grid() throws Exception {
        this.grid = new ArrayList<>();
        this.playerShips = new ArrayList<>();
        this.cpuShips = new ArrayList<>();
        this.fillGrid();

    }

    private void placeShips() {
        
    }

    // Rellena el tablero con agua para su presentación visual.
    private void fillGridWithNothing() {
        for (int index = 0; index < (this.HEIGHT * this.WIDTH); index++) {
            this.grid.add(new WaterCell());
        }
    }

    // Comprueba si un caracter es barco o no según el formato de barcos
    // 0 es agua. > 0 es barco. > 6 Error.
    private boolean isShip(String string) throws WrongShipFileException {
        int num;
        string = string.trim();
        if (string.isEmpty()) return false;
        try {
            num = Integer.parseInt(string);
            if (num >= 6) {
                throw new WrongShipFileException();
            } else if (num > 0) {
                return true;
            }
            return false;
        } catch (NumberFormatException err) {
            throw new WrongShipFileException();
        }
    }

    // Comprueba si existe ya un grupo de barcos en la lista de partes con la id
    // dada.
    private boolean hasId(ArrayList<ShipParts> list, int id) {
        for (ShipParts sp: list) {
            if (sp.getId() == id) return true;
        }
        return false;
    }

    // Localiza el índice del grupo de barcos por la id dada
    private int getShipPartsIndex(ArrayList<ShipParts> list, int id) {
        int length = list.size();
        for (int i = 0; i < length; i++) {
            ShipParts sp = list.get(i);
            if (sp.getId() == id) return i;
        }
        return -1;
    }

    // TODO:
    private void fillGrid() throws Exception {
        try {
            String shipFile = new ShipFileReader().stringify();

            for (int index = 0; index < (this.HEIGHT * this.WIDTH); index++) {
                String cell = shipFile.substring(index, index + 1);
                // Si es un barco
                if (isShip(cell)) {
                    // Obtiene la id y crea una celda de barco con dicha iden la
                    // posicion del grid actual.
                    int shipId = Integer.parseInt(cell);
                    this.grid.add(new ShipCell(shipId));

                    // Y lo añade a la lista de las localizaciones de los
                    // barcos.
                    ShipParts shipParts;

                     // Si existe un grupo de barcos selecciona el ya existente.
                    if (hasId(this.playerShips, shipId)) {
                        int idx = getShipPartsIndex(this.playerShips, shipId);
                        shipParts = this.playerShips.get(idx);
                    // Si no existe con el mismo id, lo crea.
                    } else {
                        shipParts = new ShipParts(shipId);
                    }
                    // Y le añade la parte
                    shipParts.add(index);
                // Si es agua, simplemente añade una celda de agua.
                } else {
                    this.grid.add(new WaterCell());
                }
            }
        } catch (IOException err) {
            throw new WrongShipFileException();
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
                if (DEBUG) {
                    gridText += "[" + cell.getCharacter() + "] ";
                } else if (cell instanceof ShipCell && !cell.isAttacked()) {
                    gridText += "[" + CHAR_WATER + "] ";
                } else {
                    gridText += "[" + cell.getCharacter() + "] ";
                }
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
