/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AST.jumpStatement;

import app.semanticAnalysis.Table.Node;

/**
 *
 * @author Daniel
 */
public class JS_Continue extends jumpStatement{

    public JS_Continue() {
    }

    @Override
    public void printNode() {
        System.out.println("JS_Continue");
    }

    @Override
    public void generateSymbolNode(Node symbolNode) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
