/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AST.statement;

import AST.ioExpressions.*;
import app.semanticAnalysis.Table.Table;
/**
 *
 * @author Daniel
 */
public class S_IOExpression extends Statement{
    private ioExpressions ioExp;

    public S_IOExpression(ioExpressions ioExp) {
        this.ioExp = ioExp;
    }

    public ioExpressions getIoExp() {
        return ioExp;
    }

    public void setIoExp(ioExpressions ioExp) {
        this.ioExp = ioExp;
    }

    @Override
    public void printNode() {
    }

    @Override
    public void generateSymbolTable(Table symbolTable) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
