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
 * - character representará la celda en el tablero.
 * - attackedCharacter representará la celda atacada en el tablero.
 * - attacked indica si la casilla ha sido atacada o no.
 */
public class Cell {
    private final String character;
    private final String attackedCharacter;
    private boolean attacked;

    public Cell(String character, String attackedCharacter) {
        this.attacked = false;
        this.character = character;
        this.attackedCharacter = attackedCharacter;
    }

    // Devuelve el caracter a representar.
    public String getCharacter() {
        if (this.attacked) {
            return this.attackedCharacter;
        }
        return this.character;
    }

    // Indica si la casilla ha sido atacada o no.
    public boolean isAttacked() {
        return this.attacked;
    }

    // Marca la casilla como atacada.
    public void attack() {
        this.attacked = true;
    }

}
