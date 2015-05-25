/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AST.functionDefinition;

import AST.functionTypeSpecifier.*;
import AST.compoundStatement.*;
import AST.typeParameterList.*;
import app.semanticAnalysis.Table.Node;
import app.semanticAnalysis.Table.Row;
import app.semanticAnalysis.Types.FunctionType;
import app.semanticAnalysis.Types.PrimitiveDataType;
import app.semanticAnalysis.Types.Type;
import java.util.ArrayList;

/**
 *
 * @author Daniel
 */
public class FD_FunctionDefinition extends functionDefinition {

    private functionTypeSpecifier type;
    private String id;
    private typeParameterList pL;
    private compoundStatement cS;

    public FD_FunctionDefinition(functionTypeSpecifier type, String id, compoundStatement cS) {
        this.type = type;
        this.id = id;
        this.pL = null;
        this.cS = cS;
    }

    public FD_FunctionDefinition(functionTypeSpecifier type, String id, typeParameterList pL, compoundStatement cS) {
        this.type = type;
        this.id = id;
        this.pL = pL;
        this.cS = cS;
    }

    public functionTypeSpecifier getType() {
        return type;
    }

    public void setType(functionTypeSpecifier type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public typeParameterList getpL() {
        return pL;
    }

    public void setpL(typeParameterList pL) {
        this.pL = pL;
    }

    public compoundStatement getcS() {
        return cS;
    }

    public void setcS(compoundStatement cS) {
        this.cS = cS;
    }

    @Override
    public void printNode() {
    }

    @Override
    public void generateSymbolNode(Node symbolNode) {
        if (!symbolNode.search(id) || symbolNode.getSymbolTable().getTable().isEmpty()) {
            if (this.type instanceof FTS_Type) {
                FTS_Type t = (FTS_Type) this.type;
                String t1 = t.getType().toString();
                ArrayList<Type> params = new ArrayList<>();
                switch (t1) {
                    case "int":
                        symbolNode.add(new Row(this.id, new FunctionType(params, new PrimitiveDataType(Integer.TYPE, Integer.SIZE / 8))));
                        break;
                    case "char":
                        symbolNode.add(new Row(this.id, new FunctionType(params, new PrimitiveDataType(Character.TYPE, Character.SIZE / 8))));
                        break;
                    case "double":
                        symbolNode.add(new Row(this.id, new FunctionType(params, new PrimitiveDataType(Double.TYPE, Double.SIZE / 8))));
                        break;
                    case "boolean":
                        symbolNode.add(new Row(this.id, new FunctionType(params, new PrimitiveDataType(Boolean.TYPE, 1))));
                        break;
                    case "String":
                        symbolNode.add(new Row(this.id, new FunctionType(params, new PrimitiveDataType(String.class.getSimpleName(), 255))));
                        break;
                    case "void":
                        symbolNode.add(new Row(this.id, new FunctionType(params, new PrimitiveDataType(Void.TYPE, 2))));
                        break;
                    default:
                        return;
                }

                Node novo = new Node();
                novo.setFather(symbolNode);
                symbolNode.giffBaby(novo);
                if (this.pL == null) {

                } else {
                    params = this.pL.generateSymbolNode(symbolNode.getSons().get(symbolNode.getSons().size() - 1));
                    if (params != null) {
                        t1 = t.getType().toString();
                        switch (t1) {
                            case "int":
                                symbolNode.searchRow(id).setType(new FunctionType(params, new PrimitiveDataType(Integer.TYPE, Integer.SIZE / 8)));
                                break;
                            case "char":
                                symbolNode.searchRow(id).setType(new FunctionType(params, new PrimitiveDataType(Character.TYPE, Character.SIZE / 8)));
                                break;
                            case "double":
                                symbolNode.searchRow(id).setType(new FunctionType(params, new PrimitiveDataType(Double.TYPE, Double.SIZE / 8)));
                                break;
                            case "boolean":
                                symbolNode.searchRow(id).setType(new FunctionType(params, new PrimitiveDataType(Boolean.TYPE, 1)));
                                break;
                            case "String":
                                symbolNode.searchRow(id).setType(new FunctionType(params, new PrimitiveDataType(String.class.getSimpleName(), 255)));
                                break;
                            case "void":
                                symbolNode.searchRow(id).setType(new FunctionType(params, new PrimitiveDataType(Void.TYPE, 2)));
                                break;
                            default:
                                return;
                        }
                    } else {
                        return;
                    }

                }
                this.cS.generateSymbolNode(symbolNode.getSons().get(symbolNode.getSons().size() - 1));
            }
        } else {
            System.err.println("Semantic Error: The function: \\'" + id + "\\' already exists.");
        }

    }

}
