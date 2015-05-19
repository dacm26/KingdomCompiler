/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AST.variableTypeSpecifier;

import app.semanticAnalysis.Table.Node;

/**
 *
 * @author Daniel
 */
public class VTS_Type extends variableTypeSpecifier{
    private Object type;

    public VTS_Type(Object type) {
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
