/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AST.additiveExpression;

import AST.multiplicativeExpression.*;
import app.intermediateCode.Generate;
import app.semanticAnalysis.Table.Node;

/**
 *
 * @author Daniel
 */
public class AE_Operation extends additiveExpression {

    private additiveExpression aE;
    private String operator;
    private multiplicativeExpression mE;
    private Generate generateCode;

    public AE_Operation(additiveExpression aE, String operator, multiplicativeExpression mE) {
        this.aE = aE;
        this.operator = operator;
        this.mE = mE;
    }

    public additiveExpression getaE() {
        return aE;
    }

    public void setaE(additiveExpression aE) {
        this.aE = aE;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public multiplicativeExpression getmE() {
        return mE;
    }

    public void setmE(multiplicativeExpression mE) {
        this.mE = mE;
    }

    @Override
    public void generateIC(Generate gc){
        this.generateCode = gc;
    }
    
    @Override
    public void printNode() {
        System.out.println("AE_Operation");
        this.aE.printNode();
        System.out.println(this.operator);
        this.mE.printNode();
    }

    @Override
    public int getType(Node symbolTable) {
        int type1 = this.aE.getType(symbolTable);
        int type2 = this.mE.getType(symbolTable);
        if (type1 == type2) {
            if (type1 == 2 || type1 == 3) {
                return type1;
            }
            return -1;
        } else {
            return -1;
        }
    }

}
