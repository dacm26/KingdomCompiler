/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AST.jumpFunctionStatement;

import app.semanticAnalysis.Table.Table;

/**
 *
 * @author Daniel
 */
public class JFS_EmptyReturn extends jumpFunctionStatement{

    public JFS_EmptyReturn() {
    }
    
    @Override
    public void printNode() {
    }

    @Override
    public void generateSymbolTable(Table symbolTable) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
