/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship;

import java.util.Scanner;
import battleship.Exceptions.*;
import java.io.IOException;

/**
 *
 * @author Nacho Verdón
 *
 * El clásico juego de mesa 'Hundir la flota'.
 *
 * Esta clase se encarga de manejar la interacción con el jugador.
 */
public final class Battleship {
    private static Grid grid;
    // Objeto para manejar la entrada de datos.
    private static final Scanner SC = new Scanner(System.in);;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            grid = new Grid();
            showGrids();
            grid.attackPlayerCell(2);
            showGrids();
            askForInput(grid);

        } catch (Exception err) {
            System.out.println(err.getMessage());
        }
    }

    private static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private static void showGrids() throws IOException {
        clearScreen();
        System.out.println(Text.PLAYER_GRID);
        System.out.println(grid.getPlayerGrid());
        System.out.println(Text.CPU_GRID);
        System.out.println(grid.getCPUGrid());
    }

    /**
     * Espera la entrada de datos del usuario y realiza acciones según los datos
     * introducidos.
     *
     * @param grid Tablero sobre el cual se desarrollará la acción.
     */
    private static void askForInput(Grid grid) {
        System.out.println("Gimme int: ");
        try {
            int num = SC.nextInt();

        } catch (IndexOutOfBoundsException e) {
            System.out.println("Te pasaste, muyayo. But...");

        } catch (Exception e) {
            System.out.println("Not an int. But...");
        }

        System.out.println("It's OK, dude :)");
    }

}
