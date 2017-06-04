/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package battleship;

/**
 *
 * @autor Nacho Verdón
 *
 * Estas celdas representaran las partes de los barcos. Tienen además una id que
 * las relaciona con las demás partes del mismo barco.
 */
public class ShipCell extends Cell implements Id {
    // Indica al barco al que pertenece.Varias celda tienen el mismo id para
    // relacionarlas entre si.
    private final int id;


    /**
     * @param id Identificador de las partes del barco. Todas las partes de un
     * mismo barco tendrán la misma id.
     */
    public ShipCell(int id) {
        super(Text.CHAR_SHIP, Text.CHAR_SHIP_ATTACKED);
        this.id = id;
    }

    /**
     * @return El id del barco.
     */
    @Override
    public int getId() {
        return this.id;
    }

    /**
     * @return Si la celda es de barco o no.
     */
    public boolean isShip() {
        return true;
    }
}
