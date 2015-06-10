/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AST.functionDefinition;

import AST.functionTypeSpecifier.*;
import AST.compoundStatement.*;
import AST.jumpFunctionStatement.JFS_EmptyReturn;
import AST.jumpFunctionStatement.JFS_Return;
import AST.statement.S_JFS;
import AST.statementList.SL_StatementList;
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
            int functionType = -1;
            if (this.type instanceof FTS_Type) {
                FTS_Type t = (FTS_Type) this.type;
                String t1 = t.getType().toString();
                ArrayList<Type> params = new ArrayList<>();
                switch (t1) {
                    case "int":
                        symbolNode.add(new Row(this.id, new FunctionType(params, new PrimitiveDataType(Integer.TYPE, Integer.SIZE / 8)),false));
                        functionType = 2;
                        break;
                    case "char":
                        symbolNode.add(new Row(this.id, new FunctionType(params, new PrimitiveDataType(Character.TYPE, Character.SIZE / 8)),false));
                        functionType = 1;
                        break;
                    case "double":
                        symbolNode.add(new Row(this.id, new FunctionType(params, new PrimitiveDataType(Double.TYPE, Double.SIZE / 8)),false));
                        functionType = 3;
                        break;
                    case "boolean":
                        symbolNode.add(new Row(this.id, new FunctionType(params, new PrimitiveDataType(Boolean.TYPE, 1)),false));
                        functionType = 5;
                        break;
                    case "String":
                        symbolNode.add(new Row(this.id, new FunctionType(params, new PrimitiveDataType(String.class.getSimpleName(), 255)),false));
                        functionType = 4;
                        break;
                    case "void":
                        symbolNode.add(new Row(this.id, new FunctionType(params, new PrimitiveDataType(Void.TYPE, 2)),false));
                        functionType = 6;
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
                //returnType(cS, functionType, symbolNode.getSons().get(symbolNode.getSons().size() - 1));
            }
        } else {
            System.err.println("Semantic Error: The function: \'" + id + "\' already exists.");
        }

    }

    private boolean returnType(compoundStatement ret, int type, Node sN) {
        if (ret instanceof CS_StatementList) {
            CS_StatementList stmLst = (CS_StatementList) ret;
            if (stmLst.getsL() != null && stmLst.getsL() instanceof SL_StatementList) {
                S_JFS retType = null;
                SL_StatementList stmLstTemp = (SL_StatementList) stmLst.getsL();
                do {
                    if (stmLstTemp.getStm() instanceof S_JFS) {
                        System.out.println("Se encontro el salto");
                        retType = (S_JFS) stmLstTemp.getStm();
                        break;
                    } else if (stmLstTemp.getsL() != null) {
                        System.out.println("Cambiando de stmtList");
                        if (stmLstTemp != null) {
                            stmLstTemp = (SL_StatementList) stmLstTemp.getsL();
                        }else{
                            System.out.println("Safari2");
                            break;
                        }
                        
                    } else {
                        System.out.println("Safari");
                        break;
                    }
                } while (true);
                if (retType != null && retType.getjFS() instanceof JFS_EmptyReturn) {
                    JFS_EmptyReturn retVal = (JFS_EmptyReturn) retType.getjFS();
                    if (type != 6) {
                        System.out.println("Semantic Error: Missing a return clause.");
                        return false;
                    }
                    return true;
                } else if (retType != null && retType.getjFS() instanceof JFS_Return) {
                    JFS_Return retVal = (JFS_Return) retType.getjFS();
                    ArrayList<Integer> t = retVal.getcS().getType(sN);
                    if (t.size() == 1) {
                        if (t.get(0) == type) {
                            return true;
                        } else {
                            System.err.println("Semantic Error: Missing a return clause.");
                            return false;
                        }
                    } else if (t.size() > 1) {
                        System.out.println("Toca revisar argumentos del return");
                        return true;
                    } else {
                        System.err.println("Semantic Error: Missing a return clause.");
                        return false;
                    }

                } else {
                    System.err.println("Semantic Error: Missing a return clause.");
                    return false;
                }
            } else {
                System.out.println("No es un stmt List");
                System.err.println("Semantic Error: Missing a return clause.");
                return false;
            }
        }
        System.err.println("No es un CS_StmList");
        return true;
    }

}
