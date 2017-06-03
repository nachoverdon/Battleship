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
 * El tablero se compondrá de estas celdas, las cuales utilizan un caracter para
 * ser representadas y pueden estar o no atacadas.
 */
abstract public class Cell {
    // Representará la celda en el tablero.
    private final String character;
    // Representará la celda atacada en el tablero.
    private final String attackedCharacter;
    // Indica si la casilla ha sido atacada o no.
    private boolean attacked;

    /**
     * @param character Representará la celda en el tablero.
     * @param attackedCharacter Representará la celda atacada en el tablero.
     */
    public Cell(String character, String attackedCharacter) {
        this.attacked = false;
        this.character = character;
        this.attackedCharacter = attackedCharacter;
    }

    /**
     * @return El caracter a representar.
     */
    public String getCharacter() {
        if (this.attacked) {
            return this.attackedCharacter;
        }
        return this.character;
    }

    /**
     * @return Si la casilla ha sido atacada o no.
     */
    public boolean isAttacked() {
        return this.attacked;
    }

    /**
     * Marca la casilla como atacada.
     */
    public void attack() {
        this.attacked = true;
    }

}
