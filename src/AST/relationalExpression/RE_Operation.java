/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AST.relationalExpression;

import AST.additiveExpression.*;
import app.intermediateCode.Generate;
import app.semanticAnalysis.Table.Node;

/**
 *
 * @author Daniel
 */
public class RE_Operation extends relationalExpression {

    private relationalExpression rE;
    private String operator;
    private String stringContent;
    private int result;
    private additiveExpression aE;
    private Generate generateCode;

    public RE_Operation(relationalExpression rE, String operator, additiveExpression aE) {
        this.rE = rE;
        this.operator = operator;
        this.aE = aE;
//        this.setStringContent();
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

    public void setStringContent(){
        String right = "";
        int rightResult;
        String left = "";
        int leftResult;
        if (aE instanceof AE_multiplicativeExpression){
            AE_multiplicativeExpression aEM = (AE_multiplicativeExpression)aE;
            right = aEM.getStringContent();
        } else {
            AE_Operation aEO = (AE_Operation)aE;
            right = aEO.getStringContent();
        }
        if (rE instanceof RE_additiveExpression){
            RE_additiveExpression rEA = (RE_additiveExpression)rE;
            left = rEA.getStringContent();
            this.stringContent = left + "" + operator + "" + right;
            switch(operator){
                case ">":{
                    this.result = (Integer.parseInt(left) > Integer.parseInt(right))?1:0;
                    break;
                }
                case "<":{
                    this.result = (Integer.parseInt(left) < Integer.parseInt(right))?1:0;
                    break;
                }
                case ">=":{
                    this.result = (Integer.parseInt(left) >= Integer.parseInt(right))?1:0;
                    break;
                }
                case "<=":{
                    this.result = (Integer.parseInt(left) <= Integer.parseInt(right))?1:0;
                    break;
                }
            }
        } else {
            RE_Operation rEO = (RE_Operation)rE;
            left = rEO.getStringContent();
            this.stringContent = left + "" + operator + "" + right;
            this.result = rEO.getResult();
        }
    }

    public String getStringContent(){
        return this.stringContent;
    }

    public int getResult(){
        return this.result;
    }

    @Override
    public void generateIC(Generate gc) {
        this.generateCode = gc;
    }

    @Override
    public void printNode() {
        System.out.println("RE_Operation");
        this.rE.printNode();
        System.out.println(this.operator);
        this.aE.printNode();
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
        int type1 = this.rE.getType(symbolTable);
        int type2 = this.aE.getType(symbolTable);
        if (type1 == -1 || type2 == -1) {
            return -1;
        } else {
            if (type1 == type2 && (type1 == 2 || type1 == 3)) {
                return 5;
            } else {
                return -1;
            }
        }
    }

@Override
    public void setLine(int line) {
        this.line = line+1;
    }

    @Override
    public int getLine() {
        return this.line;
    }

    @Override
    public void generateConstants(Node symbolNode) {
        this.rE.generateConstants(symbolNode);
        this.aE.generateConstants(symbolNode);
    }
    
}