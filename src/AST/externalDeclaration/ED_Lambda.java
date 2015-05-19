/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AST.externalDeclaration;

import app.semanticAnalysis.Table.Node;

/**
 *
 * @author Daniel
 */
public class ED_Lambda extends externalDeclaration{

    public ED_Lambda() {
    }

    @Override
    public void printNode() {
        System.out.println("ED_Lamda");
    }

    @Override
    public void generateSymbolNode(Node symbolNode) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
