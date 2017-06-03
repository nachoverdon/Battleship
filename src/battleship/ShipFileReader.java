/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Nacho Verdón
 */
public class ShipFileReader {
    private final String PATH = "src/ships.grid";
    private File file;
    private FileReader fr;
    private BufferedReader br;

    public ShipFileReader() {
        this.file = new File(PATH);
        try {
            this.fr = new FileReader(this.file);
            this.br = new BufferedReader(this.fr);
        } catch (FileNotFoundException err) {
            System.out.println(err.getMessage());
        }
    }

    public String stringify() throws IOException {
        String text = "";

        while (true) {
            String line = this.br.readLine();
            if (line != null) {
                text += line;
            } else break;
        }

        return text;
    }
}
