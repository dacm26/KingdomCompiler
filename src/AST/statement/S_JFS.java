/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AST.statement;

import AST.jumpFunctionStatement.*;
import app.intermediateCode.Generate;
import app.semanticAnalysis.Table.Node;
/**
 *
 * @author Daniel
 */
public class S_JFS extends Statement{
    
    private jumpFunctionStatement jFS;
    private Generate generateCode;

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
    public void generateIC(Generate gc){
        this.generateCode = gc;
        this.jFS.generateIC(this.generateCode);
    }
    
    @Override
    public void printNode() {
    }

    @Override
    public void generateSymbolNode(Node symbolNode) {
        this.jFS.generateSymbolNode(symbolNode);
    }
    
    public int getReturnType(Node symbolNode){
        return this.jFS.generateSymbolNode(symbolNode);
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