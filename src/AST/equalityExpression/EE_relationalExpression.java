/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AST.equalityExpression;
import AST.relationalExpression.*;
import app.intermediateCode.Generate;
import app.semanticAnalysis.Table.Node;
/**
 *
 * @author Daniel
 */
public class EE_relationalExpression extends equalityExpression{
    private relationalExpression rE;
    private Generate generateCode;

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
    public void generateIC(Generate gc){
        this.generateCode = gc;
    }
    
    @Override
    public void printNode() {
        System.out.println("EE_relationalExpression");
        this.rE.printNode();
    }

    @Override
    public int getType(Node symbolTable) {
        return this.rE.getType(symbolTable);
    }


    
}
