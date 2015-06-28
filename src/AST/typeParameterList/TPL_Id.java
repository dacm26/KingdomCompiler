/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AST.typeParameterList;

import AST.variableTypeSpecifier.*;
import app.semanticAnalysis.Table.Node;
import app.semanticAnalysis.Table.Row;
import app.semanticAnalysis.Types.PrimitiveDataType;
import app.semanticAnalysis.Types.Type;
import java.util.ArrayList;

/**
 *
 * @author Daniel
 */
public class TPL_Id extends typeParameterList {

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
    public ArrayList<Type> generateSymbolNode(Node symbolNode) {
        int type1 = this.vTS.getTypeAsNumber();
        ArrayList<Type> a=new ArrayList<>();
        PrimitiveDataType pDT;
        switch (type1) {
            case 1:
                pDT = new PrimitiveDataType(Character.TYPE, Character.SIZE / 8);
                symbolNode.add(new Row(this.id, pDT,true));
                break;
            case 2:
                pDT = new PrimitiveDataType(Integer.TYPE, Integer.SIZE / 8);
                symbolNode.add(new Row(this.id, pDT,true));
                break;
            case 3:
                pDT = new PrimitiveDataType(Double.TYPE, Double.SIZE / 8);
                symbolNode.add(new Row(this.id,pDT,true));
                break;
            case 4:
                pDT = new PrimitiveDataType(String.class.getSimpleName(), 255);
                symbolNode.add(new Row(this.id, pDT,true));
                break;
            case 5:
                pDT = new PrimitiveDataType(Boolean.TYPE, 1);
                symbolNode.add(new Row(this.id, pDT,true));
                break;

            default:
                System.err.println("huh?");
                symbolNode.setErrors();
                return null;
        }
        a.add(pDT);
        return a;

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