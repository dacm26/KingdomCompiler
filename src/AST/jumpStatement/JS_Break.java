/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AST.jumpStatement;

import app.semanticAnalysis.Table.Table;

/**
 *
 * @author Daniel
 */
public class JS_Break extends jumpStatement{

    public JS_Break() {
    }

    @Override
    public void printNode() {
        System.out.println("JS_Break");
    }

    @Override
    public void generateSymbolTable(Table symbolTable) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
