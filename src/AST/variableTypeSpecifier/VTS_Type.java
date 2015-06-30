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
    private int size;
    

    public VTS_Type(Object type, int size) {
        this.type = type;
        this.size=size;
        
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Object getType() {
        return type;
    }
    
    
    
    @Override
    public int getTypeAsNumber() {
        String typeT = this.type.toString();
        switch(typeT){
            case "int":
                return 2;
            case "char":
                return 1;
            case "double":
                return 3;
            case "boolean":
                return 5;
            case "String":
                return 4;
            case "void":
                return 6;
            default:
                return -1;
        }
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
    public void setLine(int line) {
        this.line = line+1;
    }

    @Override
    public int getLine() {
        return this.line;
    }
    
}
