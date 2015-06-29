/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AST.statement;

import AST.jumpIterationStatement.*;
import app.intermediateCode.Generate;
import app.semanticAnalysis.Table.Node;
/**
 *
 * @author Daniel
 */
public class S_JIS extends Statement{
    
    private jumpIterationStatement jIS;

    public S_JIS(jumpIterationStatement jIS) {
        this.jIS = jIS;
    }

    public jumpIterationStatement getjIS() {
        return jIS;
    }

    public void setjIS(jumpIterationStatement jIS) {
        this.jIS = jIS;
    }

    @Override
    public void generateIC(){
    }
    
    @Override
    public void printNode() {
    }

    @Override
    public void generateSymbolNode(Node symbolNode) {
        
    }
    
    
    
}
