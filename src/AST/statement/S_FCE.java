/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AST.statement;

import AST.functionCallsExpression.*;
import app.semanticAnalysis.Table.Table;

/**
 *
 * @author Daniel
 */
public class S_FCE extends Statement{
    private functionCallsExpression fCE;

    public S_FCE(functionCallsExpression fCE) {
        this.fCE = fCE;
    }

    public functionCallsExpression getfCE() {
        return fCE;
    }

    public void setfCE(functionCallsExpression fCE) {
        this.fCE = fCE;
    }

    @Override
    public void printNode() {
    }

    @Override
    public void generateSymbolTable(Table symbolTable) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
