/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AST.labeledStatement;

import app.semanticAnalysis.Table.Node;

/**
 *
 * @author Daniel
 */
public class LS_Lambda extends labeledStatement{

    public LS_Lambda() {
    }

    @Override
    public void printNode() {
        System.out.println("LS_Lamda");
    }

    @Override
    public boolean generateSymbolNode(Node symbolNode,String id) {
        return symbolNode.search(id);
    }
    
}
