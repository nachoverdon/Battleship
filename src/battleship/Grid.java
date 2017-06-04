/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package battleship;

import battleship.Exceptions.*;
import java.util.ArrayList;
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
    // Habilita las opciones de dugging y testeos si es true
    private final boolean DEBUG = false;
    // Lista con las celdas a representar en el tablero del jugador.
    private final ArrayList<Cell> playerGrid;
    // Lista con las celdas a representar en el tablero del oponente CPU.
    private final ArrayList<Cell> cpuGrid;
    // Lista con diferentes barcos. Éstos contienen su localización dentro del
    // tablero.
    private ArrayList<ShipParts> playerShips;
    // Como playerShips pero los barcos del tablero del oponente CPU.
    private ArrayList<ShipParts> cpuShips;
    // La altura del tablero.
    private final int HEIGHT = 10;
    // La anchura del tablero.
    private final int WIDTH = 10;

    public Grid() throws Exception {
        this.playerGrid = new ArrayList<>();
        this.cpuGrid = new ArrayList<>();
        this.playerShips = new ArrayList<>();
        this.cpuShips = new ArrayList<>();
        this.fillPlayerGrid();
        this.fillCPUGrid();

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


    // Rellena el tablero según el archivo ships.grid
    private void fillPlayerGrid() throws Exception {
        try {
            String shipFile = new ShipFileReader().stringify();

            for (int index = 0; index < (this.HEIGHT * this.WIDTH); index++) {
                String cell = shipFile.substring(index, index + 1);

                // Si es un barco
                if (isShip(cell)) {
                    // Obtiene la id y crea una celda de barco con dicha iden la
                    // posicion del grid actual.
                    int shipId = Integer.parseInt(cell);
                    this.playerGrid.add(new ShipCell(shipId));

                    // Y lo añade a la lista de las localizaciones de los
                    // barcos.
                    ShipParts shipParts;

                     // Si existe un grupo de barcos selecciona el ya existente.
                    if (hasId(this.playerShips, shipId)) {
                        int idx = getShipPartsIndex(this.playerShips, shipId);
                        shipParts = this.playerShips.get(idx);

                    // Si no existe con el mismo id, lo crea.
                    } else shipParts = new ShipParts(shipId);

                    // Y le añade la parte
                    shipParts.add(index);

                // Si es agua, simplemente añade una celda de agua.
                } else this.playerGrid.add(new WaterCell());

            }
        } catch (IOException err) {
            throw new WrongShipFileException();
        }
    }

    private void fillCPUGrid() throws Exception {
        for (int index = 0; index < (this.HEIGHT * this.WIDTH); index++) {
            this.cpuGrid.add(new WaterCell());
        }
    }

    /**
     * @return El contenido del tablero del jugador separado por lineas del
     * tamaño del WIDTH.
     */
    public final String getPlayerGrid() {
        String gridText = "";

        for (int y = 0; y < this.HEIGHT; y++) {
            for (int x = 0; x < this.WIDTH; x++) {
                int cellNumber = y * this.WIDTH + x;
                Cell cell = this.playerGrid.get(cellNumber);

                gridText += "[" + cell.getCharacter() + "] ";

            }

            gridText += "\n";
        }

        return gridText;
    }

    /**
     * @return El contenido del tablero del oponente CPU separado por lineas del
     * tamaño del WIDTH.
     */
    public final String getCPUGrid() {
        String gridText = "";

        for (int y = 0; y < this.HEIGHT; y++) {
            for (int x = 0; x < this.WIDTH; x++) {
                int cellNumber = y * this.WIDTH + x;
                Cell cell = this.cpuGrid.get(cellNumber);

                if (DEBUG) {
                    gridText += "[" + cell.getCharacter() + "] ";

                } else if (cell instanceof ShipCell && !cell.isAttacked()) {
                    gridText += "[" + Text.CHAR_WATER + "] ";

                } else gridText += "[" + cell.getCharacter() + "] ";

            }

            gridText += "\n";
        }

        return gridText;
    }

    // Marca como atacada la casilla de la posición dada en el tablero dado.
    private String attackCell(ArrayList<Cell> grid, int index) throws Exception {
        // Si ya ha sido atacada, lanza una excepción
        if (grid.get(index).isAttacked()) {
            throw new AlreadyAttackedException();
        } else grid.get(index).attack();

        // TODO:
        // if (tocado)
        //      if checkIfHundido() return tocadoYhundido;
        //      return tocado
        // return agua
        return "";
    }

    /**
     * @param index Índice de la casilla en el tablero del jugador.
     * @return El caracter de la casilla que ha atacado.
     * @throws Exception Si la casilla ya ha sido atacada previamente.
     */
    public final String attackPlayerCell(int index) throws Exception {
        return attackCell(this.playerGrid, index);
    }

    /**
     * @param index Índice de la casilla en el tablero del oponente CPU.
     * @return El caracter de la casilla que ha atacado.
     * @throws Exception Si la casilla ya ha sido atacada previamente.
     */
    public final String attackCPUCell(int index) throws Exception {
        return attackCell(this.cpuGrid, index);
    }


}
