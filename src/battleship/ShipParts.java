/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship;

import java.util.ArrayList;

/**
 *
 * @author Nacho Verdón
 *
 * Contiene las localizaciones de las celdas en las que se encuentran las partes
 * de un barco según la id.
 */
public class ShipParts implements Id {
    // Indica al barco al que pertenece.
    private final int id;
    // Lista con las posiciones de las partes.
    private ArrayList<Integer> positions;

    /**
     * @param id Identificador del barco al que pertenecen las partes.
     */
    public ShipParts(int id) {
        this.id = id;
        this.positions = new ArrayList<>();
    }

    /**
     * @param position La posición en el tablero donde se encuentra la parte a
     * añadir.
     */
    public void add(int position) {
        this.positions.add(position);
    }

    /**
     * @return Lista con las posiciones
     */
    public ArrayList getPositions() {
        return this.positions;
    }

    /**
     * @return Identificador del barco.
     */
    @Override
    public int getId() {
        return this.id;
    }
}
