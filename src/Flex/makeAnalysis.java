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
            String values[] = new String[1];
            values[0] = "./src/Flex/kcParser.cup";
            File file = new File("./src/Flex/kcScanner.flex");
            jflex.Main.generate(file);
            java_cup.Main.main(values);
        } catch (Exception e) {
            System.err.println(e);
        }
    }

}
