/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AST.functionCallsExpression;

import app.semanticAnalysis.Table.Node;

/**
 *
 * @author C5220701
 */
abstract public class functionCallsExpression {
    abstract public int generateSymbolNode(Node symbolNode);
    abstract public void setLine(int line);
    abstract public int getLine();
    protected int line;

    abstract public void generateIC();
    abstract public String getStringContent();
    abstract public void setStringContent();
}
