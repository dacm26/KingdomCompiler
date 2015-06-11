/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AST.statement;

import AST.functionCallsDeclaration.functionCallsDeclaration;
import app.semanticAnalysis.Table.Node;

/**
 *
 * @author Daniel
 */
public class S_FCD extends Statement{
    private functionCallsDeclaration fCE;

    public S_FCD(functionCallsDeclaration fCE) {
        this.fCE = fCE;
    }

    public functionCallsDeclaration getfCE() {
        return fCE;
    }

    public void setfCE(functionCallsDeclaration fCE) {
        this.fCE = fCE;
    }

    @Override
    public void printNode() {
    }

    @Override
    public void generateSymbolNode(Node symbolNode) {
        this.fCE.generateSymbolNode(symbolNode);
    }
    
}
