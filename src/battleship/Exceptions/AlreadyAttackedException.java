/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package battleship.Exceptions;

/**
 *
 * @autor Nacho Verdón
 */
public class AlreadyAttackedException extends Exception {
    public AlreadyAttackedException() {
        super("Error: Celda ya atacada.");
    }
}
