/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Flex;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import java_cup.runtime.Symbol;


/**
 *
 * @author C5220701
 */
public class Main {

    public static void main(String[] args) {
        try {
            Symbol symbol;
            parser par = new parser(new InputStreamReader(new FileInputStream("./src/resources/asd.gg")));
            symbol = par.parse();
            while ( ((symbol).sym != sym.EOF) ) {
                symbol = par.parse();

            }
            System.out.println("Fin del archivo");

        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
