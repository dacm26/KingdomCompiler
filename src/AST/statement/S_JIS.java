/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AST.statement;

import AST.jumpIterationStatement.*;
import app.semanticAnalysis.Table.Table;
/**
 *
 * @author Daniel
 */
public class S_JIS extends Statement{
    
    private jumpIterationStatement jIS;

    public S_JIS(jumpIterationStatement jIS) {
        this.jIS = jIS;
    }

    public jumpIterationStatement getjIS() {
        return jIS;
    }

    public void setjIS(jumpIterationStatement jIS) {
        this.jIS = jIS;
    }

    @Override
    public void printNode() {
    }

    @Override
    public void generateSymbolTable(Table symbolTable) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
