/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AST.statement;

import AST.functionCallsDeclaration.functionCallsDeclaration;
import app.intermediateCode.Generate;
import app.semanticAnalysis.Table.Node;

/**
 *
 * @author Daniel
 */
public class S_FCD extends Statement{
    private functionCallsDeclaration fCD;
    private Generate generateCode;
    private Node symbolN;

    public S_FCD(functionCallsDeclaration fCD) {
        this.fCD = fCD;
    }

    public functionCallsDeclaration getfCD() {
        return fCD;
    }

    public void setfCD(functionCallsDeclaration fCD) {
        this.fCD = fCD;
    }
    
    @Override
    public void generateIC(Generate gc){
        this.generateCode = gc;
        this.fCD.generateIC(this.generateCode, this.symbolN);
    }

    @Override
    public void printNode() {
    }

    @Override
    public void generateSymbolNode(Node symbolNode) {
        this.symbolN = symbolNode;
        this.fCD.generateSymbolNode(symbolNode);
    }
    
}
