/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship;

import java.util.Scanner;
import battleship.Exceptions.*;

/**
 *
 * @author Nacho Verdón
 *
 * El clásico juego de mesa 'Hundir la flota'.
 *
 * Esta clase se encarga de manejar la interacción con el jugador.
 */
public final class Battleship {
    // Objeto para manejar la entrada de datos.
    private static final Scanner SC = new Scanner(System.in);;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Grid grid = new Grid();
            askForInput(grid);
        } catch (Exception err) {
            System.out.println(err.getMessage());
        }
    }

    /**
     * Espera la entrada de datos del usuario y realiza acciones según los datos
     * introducidos.
     *
     * @param grid Tablero sobre el cual se desarrollará la acción.
     */
    public static void askForInput(Grid grid) {
        System.out.println("Gimme int: ");
        try {
            int num = SC.nextInt();
            System.out.println(grid.getByIndexTest(num));
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Te pasaste, muyayo. But...");
        } catch (Exception e) {
            System.out.println("Not an int. But...");
        }
        System.out.println("It's OK, dude :)");
    }

}
