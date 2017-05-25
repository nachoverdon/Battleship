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
 * Representa los barcos que se colocan en el tablero. Los demás subtipos de
 * barco heredan sus propiedades.
 */
abstract public class Ship {
    private final String typeName;
    private final int length;
    private int[] parts;

    public Ship(String typeName, int length) {
        this.typeName = typeName;
        this.length = length;
    }

    // Devuelve el tamaño del barco
    public int getLength() {
        return this.length;
    }

    // Devuelve el tipo de barco
    public String getTypeName() {
        return this.typeName;
    }

    // Devuelve la localización de las partes en el tablero en forma de índice
    public int[] getParts() {
        return this.parts;
    }

    // Asigna la localización de las partes del barco en forma de índice
    public void setParts(int[] parts) {
        this.parts = parts;
    }
}
