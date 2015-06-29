/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AST.jumpFunctionStatement;

import app.intermediateCode.Generate;
import app.semanticAnalysis.Table.Node;

/**
 *
 * @author Daniel
 */
public class JFS_EmptyReturn extends jumpFunctionStatement{

    private Generate generateCode;
    
    public JFS_EmptyReturn() {
    }
    
    @Override
    public void generateIC(){
    }
    
    @Override
    public void printNode() {
    }

    @Override
    public int generateSymbolNode(Node symbolNode) {
        return 6;
    }
    
}
