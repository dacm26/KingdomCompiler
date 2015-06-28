/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AST.typeParameterList;

import app.semanticAnalysis.Table.Node;
import app.semanticAnalysis.Types.Type;
import java.util.ArrayList;

/**
 *
 * @author Daniel
 */
public abstract class typeParameterList {
    abstract public void printNode();
    abstract public ArrayList<Type> generateSymbolNode(Node symbolNode);
    abstract public void setLine(int line);
    abstract public int getLine();
    protected int line;
}
