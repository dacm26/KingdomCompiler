/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AST.mainFunctionDeclaration;

import app.semanticAnalysis.Table.Node;
import app.intermediateCode.Generate;

/**
 *
 * @author Daniel
 */
abstract public class mainFunctionDeclaration {
    abstract public void printNode();
    abstract public void generateSymbolNode(Node symbolNode);
    abstract public void generateIC();
}
