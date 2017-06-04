/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship.Exceptions;

import battleship.Text;

/**
 *
 * @author Nacho Verdón
 */
public class WrongShipFileException extends Exception {
    public WrongShipFileException() {
        super(Text.WRONG_SHIP_FILE_EX);
    }
}
