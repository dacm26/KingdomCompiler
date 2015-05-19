/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AST.multiplicativeExpression;
import AST.basicExpression.*;
import app.semanticAnalysis.Table.Table;
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

    @Override
    public void generateSymbolTable(Table symbolTable) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
