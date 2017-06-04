/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship;

/**
 *
 * @author Nacho Verdón
 * Estas celdas representaran el agua (casilla sin barco).
 */
public class WaterCell extends Cell {

    public WaterCell() {
        super(Text.CHAR_WATER, Text.CHAR_WATER_ATTACKED);
    }
}
