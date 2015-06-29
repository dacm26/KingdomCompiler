/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AST.basicExpression;

import AST.functionCallsExpression.functionCallsExpression;
import app.intermediateCode.Generate;
import app.semanticAnalysis.Table.Node;

/**
 *
 * @author C5220701
 */
public class BE_FCE extends basicExpression{
    
    private functionCallsExpression fCE;
    private String stringContent;
    private Generate generateCode;

    public BE_FCE(functionCallsExpression fCE, Generate generateCode) {
        this.fCE = fCE;
        this.generateCode = generateCode;
    }

    public functionCallsExpression getfCE() {
        return fCE;
    }

    public void setfCE(functionCallsExpression fCE) {
        this.fCE = fCE;
    }

    @Override
    public void setStringContent(){

    }

    @Override
    public String getStringContent(){
        return this.stringContent;
    }

    public void generateIC(){
    }
    
    @Override
    public void printNode() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getType(Node symbolTable) {
        return fCE.generateSymbolNode(symbolTable);
    }
    
}
