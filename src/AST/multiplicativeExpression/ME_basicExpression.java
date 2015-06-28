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

    public ME_basicExpression(basicExpression bE) {
        this.bE = bE;
//        this.setStringContent();
    }

    public basicExpression getbE() {
        return bE;
    }

    public void setbE(basicExpression bE) {
        this.bE = bE;
    }

    public void setStringContent(){
        BE_primaryExpression bEP = (BE_primaryExpression) bE;
        this.stringContent = bEP.getStringContent();
        if (bEP.getResult() == Integer.MAX_VALUE){
            if (stringContent != "false" && stringContent != "true"){
                result = Integer.parseInt(stringContent);
            } else {
                result = (stringContent.equals("true"))?1:0;
            }
        } else {
            result = bEP.getResult();
        }
    }

    public int getResult(){
        return result;
    }

    public String getStringContent(){
        return this.stringContent;
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

@Override
    public void setLine(int line) {
        this.line = line+1;
    }

    @Override
    public int getLine() {
        return this.line;
    }
    
}