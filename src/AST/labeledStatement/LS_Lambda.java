/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AST.labeledStatement;

import app.semanticAnalysis.Table.Table;

/**
 *
 * @author Daniel
 */
public class LS_Lambda extends labeledStatement{

    public LS_Lambda() {
    }

    @Override
    public void printNode() {
        System.out.println("LS_Lamda");
    }

    @Override
    public void generateSymbolTable(Table symbolTable) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
