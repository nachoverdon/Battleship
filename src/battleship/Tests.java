/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Nacho Verdón
 */
public class Tests {
    public static void main(String[] args) {
        System.out.println(obtMayNum(new int[] {1, 3, 5, 90}));
        System.out.println("lol".substring(1, 2));
        System.out.println(Integer.parseInt("\n".trim()));
        ShipFileReader sfr = new ShipFileReader();
        try {
            System.out.println(sfr.stringify());
        } catch (Exception err) {
            System.out.print("Tests.java - line 20 ");
            System.out.println(err.getMessage());
        }

        File file = new File("src/ships.grid");
        try {
            System.out.println("");
            FileReader fr = new FileReader(file);
            int chr = fr.read();
            String str = "";
            while (chr != -1) {
                str += chrToStr(chr);
                chr = fr.read();
            }
            System.out.println(str);
        } catch (IOException err) {
            System.out.println(err.getMessage());
        }
    }

    private static int obtMayNum(int list[]) {
        int idx, max = Integer.MIN_VALUE;

        for (idx = 0; idx < list.length; idx++) {
            if (list[idx] > max) max = list[idx];
        }

        return max;
    }

    private static String chrToStr(int asciiCode) {
        return Character.toString((char) asciiCode);
    }
}
