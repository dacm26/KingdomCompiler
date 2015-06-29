/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AST.multiplicativeExpression;
import AST.basicExpression.*;
import app.intermediateCode.Generate;
import app.semanticAnalysis.Table.Node;
/**
 *
 * @author Daniel
 */
public class ME_Operation extends multiplicativeExpression{
    private multiplicativeExpression mE;
    private String operator;
    private basicExpression bE;
    private int result;
    private String stringContent;
    private Generate generateCode;

    public ME_Operation(multiplicativeExpression mE, String operator, basicExpression bE) {
        this.mE = mE;
        this.operator = operator;
        this.bE = bE;
        this.setStringContent();
    }

    public multiplicativeExpression getmE() {
        return mE;
    }

    public void setmE(multiplicativeExpression mE) {
        this.mE = mE;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public basicExpression getbE() {
        return bE;
    }

    public void setStringContent(){       
        if (mE instanceof ME_basicExpression){
            BE_primaryExpression bEP = (BE_primaryExpression)bE;
            String right = bEP.getStringContent();
            String left = "";
            ME_basicExpression mEB = (ME_basicExpression)mE;
            left = mEB.getStringContent();  
            this.stringContent = left + "" + this.operator + "" + right;
            if (mEB.getResult() == Integer.MAX_VALUE || bEP.getResult() == Integer.MAX_VALUE){
                if (operator == "*")
                    this.result = Integer.parseInt(left) * Integer.parseInt(right);
                else 
                    this.result = Integer.parseInt(left) / Integer.parseInt(right);
            } else {
                if (operator == "*")
                    this.result = mEB.getResult() * bEP.getResult();
                else 
                    this.result = mEB.getResult() / bEP.getResult();
            }
        } else {
            System.out.println("hola");
            BE_primaryExpression bEP = (BE_primaryExpression)bE;
            String right = bEP.getStringContent();
            String left = "";
            ME_Operation mEB = (ME_Operation)mE;
            left = mEB.getStringContent();  
            this.stringContent = left + "" + this.operator + "" + right;
            if (mEB.getResult() == Integer.MAX_VALUE){
                if (operator == "*")
                    this.result = mEB.getResult() * bEP.getResult();
                else 
                    this.result = mEB.getResult() / bEP.getResult();
            } else {
                if (operator == "*")
                    this.result = mEB.getResult() * bEP.getResult();
                else 
                    this.result = mEB.getResult() / bEP.getResult();
            }
        }
    }

    public String getStringContent(){
        return this.stringContent;
    }

    public int getResult(){
        return result;
    }

    public void setbE(basicExpression bE) {
        this.bE = bE;
    }
    
    @Override
    public void generateIC(Generate gc){
        this.generateCode = gc;
    }

    @Override
    public void printNode() {
        System.out.println("ME_Operation");
        this.mE.printNode();
        System.out.println(this.operator);
        this.bE.printNode();
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
        int type1 = this.mE.getType(symbolTable);
        int type2 = this.bE.getType(symbolTable);
        if (type1 == type2 ) {
            if (type1 == 2 || type1 == 3 ) {
                return type1;
            }
            return -1;
        }else{
            return -1;
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
        this.bE.generateConstants(symbolNode);
        this.mE.generateConstants(symbolNode);
    }
    
}