/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AST.relationalExpression;
import AST.additiveExpression.*;
import app.semanticAnalysis.Table.Node;
/**
 *
 * @author Daniel
 */
public class RE_Operation extends relationalExpression{
   private relationalExpression rE;
   private String operator;
   private additiveExpression aE;

    public RE_Operation(relationalExpression rE, String operator, additiveExpression aE) {
        this.rE = rE;
        this.operator = operator;
        this.aE = aE;
    }

    public relationalExpression getrE() {
        return rE;
    }

    public void setrE(relationalExpression rE) {
        this.rE = rE;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public additiveExpression getaE() {
        return aE;
    }

    public void setaE(additiveExpression aE) {
        this.aE = aE;
    }

    @Override
    public void printNode() {
        System.out.println("RE_Operation");
        this.rE.printNode();
        System.out.println(this.operator);
        this.aE.printNode();
    }

    @Override
    public void generateSymbolNode(Node symbolNode) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
}
