/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AST.additiveExpression;
import AST.multiplicativeExpression.*;
import app.semanticAnalysis.Table.Table;
/**
 *
 * @author Daniel
 */
public class AE_multiplicativeExpression extends additiveExpression{
    private multiplicativeExpression mE;

    public AE_multiplicativeExpression(multiplicativeExpression mE) {
        this.mE = mE;
    }

    public multiplicativeExpression getbE() {
        return mE;
    }

    public void setbE(multiplicativeExpression mE) {
        this.mE = mE;
    }

    @Override
    public void printNode() {
        System.out.println("AE_multiplicativeExpression");
        this.mE.printNode();
    }

    @Override
    public void generateSymbolTable(Table symbolTable) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
