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
    private Generate generateCode;

    public BE_FCE(functionCallsExpression fCE) {
        this.fCE = fCE;
    }

    public functionCallsExpression getfCE() {
        return fCE;
    }

    public void setfCE(functionCallsExpression fCE) {
        this.fCE = fCE;
    }
    
    @Override
    public void generateIC(Generate gc){
        this.generateCode = gc;
    }
    
    @Override
    public void printNode() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getType(Node symbolTable) {
        return fCE.generateSymbolNode(symbolTable);
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
        //asdadsa
        System.err.println("not implemented yet");
    }
    
}