/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AST.labeledStatement;
import AST.compoundStatement.*;
import app.semanticAnalysis.Table.Table;
/**
 *
 * @author Daniel
 */
public class LS_Default extends labeledStatement{
    private compoundStatement stm;

    public LS_Default(compoundStatement stm) {
        this.stm = stm;
    }


    public compoundStatement getStm() {
        return stm;
    }

    public void setStm(compoundStatement stm) {
        this.stm = stm;
    }

    @Override
    public void printNode() {

    }

    @Override
    public void generateSymbolTable(Table symbolTable) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
