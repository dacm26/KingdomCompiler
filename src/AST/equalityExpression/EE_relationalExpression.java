/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AST.equalityExpression;
import AST.relationalExpression.*;
import app.semanticAnalysis.Table.Table;
/**
 *
 * @author Daniel
 */
public class EE_relationalExpression extends equalityExpression{
    private relationalExpression rE;

    public EE_relationalExpression(relationalExpression rE) {
        this.rE = rE;
    }

    public relationalExpression getrE() {
        return rE;
    }

    public void setrE(relationalExpression rE) {
        this.rE = rE;
    }

    @Override
    public void printNode() {
        System.out.println("EE_relationalExpression");
        this.rE.printNode();
    }

    @Override
    public void generateSymbolTable(Table symbolTable) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
