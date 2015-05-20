/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AST.basicExpression;
import AST.primaryExpression.*;
import app.semanticAnalysis.Table.Node;
/**
 *
 * @author Daniel
 */
public class BE_primaryExpression extends basicExpression{
    private primaryExpression pE;

    public BE_primaryExpression(primaryExpression pE) {
        this.pE = pE;
    }

    public primaryExpression getpE() {
        return pE;
    }

    public void setpE(primaryExpression pE) {
        this.pE = pE;
    }

    @Override
    public void printNode() {
        System.out.println("BE_primaryExpression");
        this.pE.printNode();
    }

    @Override
    public int getType(Node symbolTable) {
        return this.pE.getType(symbolTable);
    }

    
}
