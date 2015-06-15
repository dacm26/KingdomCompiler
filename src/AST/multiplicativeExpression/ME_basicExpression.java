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
public class ME_basicExpression extends multiplicativeExpression {

    private basicExpression bE;
    private Generate generateCode;

    public ME_basicExpression(basicExpression bE) {
        this.bE = bE;
    }

    public basicExpression getbE() {
        return bE;
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
        System.out.println("ME_basicExpression");
        this.bE.printNode();
    }

    @Override
    public int getType(Node symbolTable) {
        return this.bE.getType(symbolTable);
    }

}
