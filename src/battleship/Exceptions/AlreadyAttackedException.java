/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package battleship.Exceptions;

import battleship.Text;

/**
 *
 * @autor Nacho Verdón
 */
public class AlreadyAttackedException extends Exception {
    public AlreadyAttackedException() {
        super(Text.ALREADY_ATTACKED_EX);
    }
}
