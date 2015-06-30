/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AST.ioExpressions;

import app.intermediateCode.Generate;
import app.semanticAnalysis.Table.Node;

/**
 *
 * @author C5220701
 */
abstract public class ioExpressions {
    abstract public void printNode();
    abstract public void generateSymbolNode(Node symbolNode);
    abstract public void generateIC(Generate generateCode);
}
