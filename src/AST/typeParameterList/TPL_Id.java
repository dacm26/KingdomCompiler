/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AST.typeParameterList;

import AST.variableTypeSpecifier.*;
import app.semanticAnalysis.Table.Node;
/**
 *
 * @author Daniel
 */
public class TPL_Id extends typeParameterList{
    
    private variableTypeSpecifier vTS;
    private String id;

    public TPL_Id(variableTypeSpecifier vTS, String id) {
        this.vTS = vTS;
        this.id = id;
    }

    public variableTypeSpecifier getvTS() {
        return vTS;
    }

    public void setvTS(variableTypeSpecifier vTS) {
        this.vTS = vTS;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    
    
    @Override
    public void printNode() {
    }

    @Override
    public void generateSymbolNode(Node symbolNode) {
        
    }
    
}
