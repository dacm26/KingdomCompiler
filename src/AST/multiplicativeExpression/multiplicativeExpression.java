/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AST.multiplicativeExpression;

import AST.additiveExpression.AE_multiplicativeExpression;
import AST.additiveExpression.additiveExpression;
import app.semanticAnalysis.Table.Node;

/**
 *
 * @author Daniel
 */
abstract public class multiplicativeExpression {
    abstract public void printNode();
    abstract public void generateSymbolNode(Node symbolNode);
    abstract public int getMultiplicativeType(Node symbolNode,additiveExpression temp3);
    
}
