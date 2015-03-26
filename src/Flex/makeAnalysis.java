/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Flex;

import java.io.File;

/**
 *
 * @author Daniel
 */
public class makeAnalysis {

    public static void main(String[] args) {
        try {
            File parser = new File("./src/Flex/parser.java");
            File sym = new File("./src/Flex/sym.java");
            if (parser.exists()){
                parser.delete();
            }
            if (sym.exists()){
                sym.delete();
            }
            String values[] = new String[6];
            File file = new File("./src/Flex/kcScanner.flex");
            String opciones[] = new String[7];
            opciones[0] = "-destdir";
            opciones[1] = "src/Flex";
            opciones[2] = "-parser";
            opciones[3] = "parser";
            opciones[4] = "-symbols";
            opciones[5] = "sym";
            opciones[6] = "src/Flex/kcParser.cup";
            jflex.Main.generate(file);
            java_cup.Main.main(opciones);
        } catch (Exception e) {
            System.err.println(e);
        }
    }

}
