/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AST.parameterList;

import AST.expression.*;
import app.semanticAnalysis.Table.Table;

/**
 *
 * @author Daniel
 */
public class PL_ExpressionList extends parameterList{
    private Expression exp;
    private parameterList pL;

    public PL_ExpressionList(parameterList pL,Expression exp) {
        this.exp = exp;
        this.pL = pL;
    }
    
    
    public Expression getExp() {
        return exp;
    }

    public void setExp(Expression exp) {
        this.exp = exp;
    }

    public parameterList getpL() {
        return pL;
    }

    public void setpL(parameterList pL) {
        this.pL = pL;
    }
    
    

    @Override
    public void printNode() {
    }

    @Override
    public void generateSymbolTable(Table symbolTable) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
