/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AST.statement;

import AST.jumpFunctionStatement.*;
import app.semanticAnalysis.Table.Node;
/**
 *
 * @author Daniel
 */
public class S_JFS extends Statement{
    
    private jumpFunctionStatement jFS;

    public S_JFS(jumpFunctionStatement jFS) {
        this.jFS = jFS;
    }

    public jumpFunctionStatement getjFS() {
        return jFS;
    }

    public void setjFS(jumpFunctionStatement jFS) {
        this.jFS = jFS;
    }
    
    
    
    @Override
    public void printNode() {
    }

    @Override
    public void generateSymbolNode(Node symbolNode) {
        
    }
    
}
