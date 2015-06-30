/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AST.jumpIterationStatement;

import app.semanticAnalysis.Table.Node;

/**
 *
 * @author Daniel
 */
public class JIS_Continue extends jumpIterationStatement{

    public JIS_Continue() {
    }
    
    @Override
    public void printNode() {
    }

    @Override
    public void generateSymbolNode(Node symbolNode) {
        
    }
    
@Override
    public void setLine(int line) {
        this.line = line+1;
    }

    @Override
    public int getLine() {
        return this.line;
    }
    
}