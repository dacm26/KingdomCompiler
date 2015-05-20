/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AST.equalityExpression;
import AST.relationalExpression.*;
import app.semanticAnalysis.Table.Node;
/**
 *
 * @author Daniel
 */
public class EE_Operation extends equalityExpression{
    private equalityExpression eE;
    private String operator;
    private relationalExpression rE;

    public EE_Operation(equalityExpression eE, String operator, relationalExpression rE) {
        this.eE = eE;
        this.operator = operator;
        this.rE = rE;
    }

    public equalityExpression geteE() {
        return eE;
    }

    public void seteE(equalityExpression eE) {
        this.eE = eE;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public relationalExpression getrE() {
        return rE;
    }

    public void setrE(relationalExpression rE) {
        this.rE = rE;
    }

    @Override
    public void printNode() {
        System.out.println("EE_Operation");
        this.eE.printNode();
        System.out.println(this.operator);
        this.rE.printNode();
    }
        /*
         char = 1
         int = 2
         double = 3
         string = 4
         boolean = 5
         error = -1
        */
    @Override
    public int getType(Node symbolTable) {
        int type1 = this.eE.getType(symbolTable);
        int type2 = this.rE.getType(symbolTable);
        if (type1==type2 && (type1 ==2 || type1 ==3 || type1 ==5)) {
            return 5;
        }else{
            System.err.println("Error, Type mismatch (EE_Operation)");
            return -1;
        }
    }

    
}
