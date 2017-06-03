/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship.Exceptions;

/**
 *
 * @author Nacho Verdón
 */
public class WrongShipFileException extends Exception {
    public WrongShipFileException() {
        super("Error en el fichero de barcos. Por favor, lee la documentación"
                + "\npara saber como rellenar correctamente dicho fichero.");
    }
}
