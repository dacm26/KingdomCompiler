/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AST.jumpFunctionStatement;

import app.intermediateCode.Generate;
import app.semanticAnalysis.Table.Node;

/**
 *
 * @author Daniel
 */
public abstract class jumpFunctionStatement {
    public abstract void printNode();
    abstract public int generateSymbolNode(Node symbolNode);
    abstract public void generateIC(Generate gc);
}
