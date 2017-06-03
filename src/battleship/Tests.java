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
        File file = new File("src/ships.grid");
        try {
            FileReader fr = new FileReader(file);
            int chr = fr.read();
            String str = "";
            while (chr != -1) {
                str += "[";
                str += chrToStr(chr);
                str += "]";
                chr = fr.read();
                System.out.print(str);
            }
            System.out.println(str);
        } catch (IOException err) {
            System.out.println(err.getMessage());
        }
    }

    private static String chrToStr(int asciiCode) {
        return Character.toString((char) asciiCode);
    }
}
