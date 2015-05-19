/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AST.typeParameterList;

import app.semanticAnalysis.Table.Node;

/**
 *
 * @author Daniel
 */
public abstract class typeParameterList {
    abstract public void printNode();
    abstract public void generateSymbolNode(Node symbolNode);
}
