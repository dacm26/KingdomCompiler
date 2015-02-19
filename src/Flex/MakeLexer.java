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
public class MakeLexer {

    public static void main(String[] args) {
        try {
            File file = new File("./src/Flex/kingdomCompiler.flex");
            jflex.Main.generate(file);
        } catch (Exception e) {
            System.err.println(e);
        }
    }

}
