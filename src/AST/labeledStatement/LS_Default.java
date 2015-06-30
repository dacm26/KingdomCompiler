/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AST.labeledStatement;

import AST.compoundStatement.*;
import app.semanticAnalysis.Table.Node;

/**
 *
 * @author Daniel
 */
public class LS_Default extends labeledStatement {

    private compoundStatement stm;

    public LS_Default(compoundStatement stm) {
        this.stm = stm;
    }

    public compoundStatement getStm() {
        return stm;
    }

    public void setStm(compoundStatement stm) {
        this.stm = stm;
    }

    @Override
    public void printNode() {

    }

    @Override
    public boolean generateSymbolNode(Node symbolNode, String id) {
        Node novo = new Node();
        novo.setFather(symbolNode);
        symbolNode.giffBaby(novo);
        this.stm.generateSymbolNode(symbolNode.getSons().get(symbolNode.getSons().size() - 1));
        return true;
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