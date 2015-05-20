/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AST.multiplicativeExpression;
import AST.basicExpression.*;
import app.semanticAnalysis.Table.Node;
/**
 *
 * @author Daniel
 */
public class ME_Operation extends multiplicativeExpression{
    private multiplicativeExpression mE;
    private String operator;
    private basicExpression bE;

    public ME_Operation(multiplicativeExpression mE, String operator, basicExpression bE) {
        this.mE = mE;
        this.operator = operator;
        this.bE = bE;
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

    public void setbE(basicExpression bE) {
        this.bE = bE;
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
        if (type1 == type2 && (type1 == 2 || type1 == 3)) {
            return type1;
        }else{
            System.err.println("Error, Type mismatch (ME_Operation)");
            return -1;
        }
    }
    
}
