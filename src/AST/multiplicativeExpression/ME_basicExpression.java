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
    private String stringContent;
    private int result;
    private Generate generateCode;

    public ME_basicExpression(basicExpression bE, Generate generateCode) {
        this.bE = bE;
        this.generateCode = generateCode;
        this.setStringContent();
    }

    public basicExpression getbE() {
        return bE;
    }

    public void setbE(basicExpression bE) {
        this.bE = bE;
    }

    /*public void getGenerateCode(){
        return generateCode;
    }*/

    @Override
    public void setStringContent(){
        BE_primaryExpression bEP = (BE_primaryExpression) bE;
        this.stringContent = bEP.getStringContent();
    }

    @Override
    public String getStringContent(){
        return this.stringContent;
    }
    
    @Override
    public void generateIC(){
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
