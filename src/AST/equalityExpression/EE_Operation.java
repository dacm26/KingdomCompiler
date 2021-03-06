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
public class EE_Operation extends equalityExpression{
    private equalityExpression eE;
    private String operator;
    private String stringContent;
    private int result;
    private relationalExpression rE;
    private Generate generateCode;

    public EE_Operation(equalityExpression eE, String operator, relationalExpression rE) {
        this.eE = eE;
        this.operator = operator;
        this.rE = rE;
        this.setStringContent();
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
    public void setStringContent(){
        String right = "";
        int rightResult;
        String left = "";
        int leftResult;
        if (rE instanceof RE_additiveExpression){
            RE_additiveExpression rEO = (RE_additiveExpression)rE;
            right = rEO.getStringContent();
        } else {
            RE_Operation rEO = (RE_Operation)rE;
            right = rEO.getStringContent();
        }
        if(eE instanceof EE_relationalExpression){
            EE_relationalExpression eER = (EE_relationalExpression)eE;
            left = eER.getStringContent();
            this.stringContent = left + "" + operator + "" + right;
            switch (operator){
                case "==":{
                    this.result = (Integer.parseInt(left) == Integer.parseInt(right))?1:0;
                    break;
                }
                case "!=":{
                    this.result = (Integer.parseInt(left) != Integer.parseInt(right))?1:0;
                    break;
                }
            }
        } else {
            EE_Operation eEO = (EE_Operation)eE;
            this.stringContent = left + "" + operator + "" + right;
            this.result = eEO.getResult();
        }
    }

    public String getStringContent(){
        return this.stringContent;
    }

    public int getResult(){
        return result;
    }
    
    @Override
    public void generateIC(Generate gc){
        this.generateCode = gc;
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
        if (type1==type2 ) {
            if (type1 == 2) {
                return 5;
            }
            else if (type1 == 3) {
                return 5;
            }
            else if (type1 == 5) {
                return 5;
            }
            return -1;
        }else{
            return -1;
        }
    }

    
}
