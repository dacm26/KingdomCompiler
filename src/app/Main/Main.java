/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.Main;

import app.syntaxAnalysis.sym;
import app.syntaxAnalysis.parser;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java_cup.runtime.Symbol;


/**
 *
 * @author C5220701
 */
public class Main {

    public static void main(String[] args) {
        try {
            Symbol symbol;
            parser par = new parser(new InputStreamReader(new FileInputStream("./src/resources/test1.gg")));
            symbol = par.parse();
            while ( ((symbol).sym != sym.EOF) ) {
                symbol = par.parse();

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
