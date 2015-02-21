/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Flex;

import Flex.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
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
        kcScanner lex;
        try {
            lex = new kcScanner(new InputStreamReader(new FileInputStream("./src/resources/test.gg")));
            Symbol symbol;
            while ((symbol = lex.next_token()) != null) {
                System.out.print(sym.terminalNames[symbol.sym]);
                if (symbol.value != null) {
                    System.out.print(" " + symbol.value);
                }

                System.out.println("");
            }
            System.out.println("");

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
