/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AST.statementList;
import AST.statement.*;
import app.semanticAnalysis.Table.Table;
/**
 *
 * @author Daniel
 */
public class SL_Statement extends statementList{
    private Statement stm;

    public SL_Statement(Statement stm) {
        this.stm = stm;
    }

    public Statement getStm() {
        return stm;
    }

    public void setStm(Statement stm) {
        this.stm = stm;
    }

    @Override
    public void printNode() {
        System.out.println("SL_Statement");
        this.stm.printNode();
    }

    @Override
    public void generateSymbolTable(Table symbolTable) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
