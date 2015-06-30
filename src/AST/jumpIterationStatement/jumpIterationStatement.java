/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AST.jumpIterationStatement;

import app.semanticAnalysis.Table.Node;

/**
 *
 * @author Daniel
 */
public abstract class jumpIterationStatement {
    public abstract void printNode();
    abstract public void generateSymbolNode(Node symbolNode);
    abstract public void setLine(int line);
    abstract public int getLine();
    protected int line;
}
