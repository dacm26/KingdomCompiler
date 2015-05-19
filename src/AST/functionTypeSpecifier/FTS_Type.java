/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AST.functionTypeSpecifier;

import app.semanticAnalysis.Table.Node;


/**
 *
 * @author Daniel
 */
public class FTS_Type extends functionTypeSpecifier{
    private Object type;

    public FTS_Type(Object type) {
        this.type = type;
    }

    public Object getType() {
        return type;
    }

    public void setType(Object type) {
        this.type = type;
    }

    @Override
    public void printNode() {
        System.out.println("VTS_Type");
        System.out.println(this.type);
    }

    @Override
    public void generateSymbolNode(Node symbolNode) {
        
    }
    
}
