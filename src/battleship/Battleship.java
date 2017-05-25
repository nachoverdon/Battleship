/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship;

import java.util.Scanner;

/**
 *
 * @author Nacho Verdón
 */
public final class Battleship {
    private static final Scanner SC = new Scanner(System.in);;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Grid grid = new Grid();
        askForInput(grid);
    }

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
