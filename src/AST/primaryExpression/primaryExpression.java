/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AST.primaryExpression;

import app.intermediateCode.Generate;
import app.semanticAnalysis.Table.Node;

/**
 *
 * @author Daniel
 */
abstract public class primaryExpression {
    abstract public void printNode();
    abstract public int getType(Node symbolTable);
    abstract public void setLine(int line);
    abstract public int getLine();
    protected int line;
    abstract public void generateConstants(Node symbolNode);
    abstract public void generateIC();
}
