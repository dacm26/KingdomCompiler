/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AST.parameterList;

import app.intermediateCode.Generate;
import app.semanticAnalysis.Table.Node;
import java.util.ArrayList;

/**
 *
 * @author Daniel
 */
public abstract class parameterList {
    public abstract void printNode();
    abstract public void generateSymbolNode(Node symbolNode);
    abstract public boolean validExpression(Node symbolNode);
    abstract public ArrayList<Integer> getTypes(Node symbolNode);
    abstract public void generateIC();
}
