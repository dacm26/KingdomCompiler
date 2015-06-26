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
public class TPL_List extends typeParameterList {

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
    public ArrayList<Type> generateSymbolNode(Node symbolNode) {
        ArrayList<Type> a = this.tPL.generateSymbolNode(symbolNode);
        if (!symbolNode.search(id) && a != null) {
            int type1 = this.vTS.getTypeAsNumber();
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
                    symbolNode.add(new Row(this.id, pDT,true));
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
        } else {
            String errorMsg = "Semantic Error: The param: \'" + id + "\' already exists in the function.";
            System.err.println(errorMsg);
            symbolNode.setErrors();
            return null;
        }

    }

}
