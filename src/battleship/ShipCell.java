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
 * - id indica al barco al que pertenece. Varias celda tienen el mismo id para
 * - relacionarlas entre si.
 */
public class ShipCell extends Cell {
    private final int id;

    public ShipCell(String character, String attackedCharacter, int id) {
        super(character, attackedCharacter);
        this.id = id;
    }

    // Devuelve el id del barco.
    public int getId() {
        return this.id;
    }

    // Indica si la celda es de barco.
    public boolean isShip() {
        return true;
    }
}
