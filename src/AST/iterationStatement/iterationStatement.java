package AST.iterationStatement;

import app.semanticAnalysis.Table.Node;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Daniel
 */
abstract public class iterationStatement {
    abstract public void printNode();
    abstract public void generateSymbolNode(Node symbolNode);
}
