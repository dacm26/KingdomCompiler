/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AST.statement;

import AST.jumpFunctionStatement.*;
import app.semanticAnalysis.Table.Table;
/**
 *
 * @author Daniel
 */
public class S_JFS extends Statement{
    
    private jumpFunctionStatement jFS;

    public S_JFS(jumpFunctionStatement jFS) {
        this.jFS = jFS;
    }

    public jumpFunctionStatement getjFS() {
        return jFS;
    }

    public void setjFS(jumpFunctionStatement jFS) {
        this.jFS = jFS;
    }
    
    
    
    @Override
    public void printNode() {
    }

    @Override
    public void generateSymbolTable(Table symbolTable) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
