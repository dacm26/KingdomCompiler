/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AST.declaration;
import app.semanticAnalysis.Table.Node;

/**
 *
 * @author Daniel
 */
abstract public class Declaration {
    abstract public void printNode();
    abstract public void generateSymbolNode(Node symbolNode);
}
