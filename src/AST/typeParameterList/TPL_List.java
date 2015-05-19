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
public class TPL_List extends typeParameterList{
    
    private typeParameterList tPL;
    private variableTypeSpecifier vTS;
    private String id;

    public TPL_List(typeParameterList tPL, variableTypeSpecifier vTS, String id) {
        this.tPL = tPL;
        this.vTS = vTS;
        this.id = id;
    }

    public typeParameterList gettPL() {
        return tPL;
    }

    public void settPL(typeParameterList tPL) {
        this.tPL = tPL;
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
