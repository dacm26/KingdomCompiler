/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AST.compoundStatement;

import app.semanticAnalysis.Table.Node;

/**
 *
 * @author Daniel
 */
public class CS_Empty extends compoundStatement{

    public CS_Empty() {
    }

    @Override
    public void printNode() {
        System.out.println("CS_Empty");
    }

    @Override
    public void generateSymbolNode(Node symbolNode) {
        
    }
    
}
