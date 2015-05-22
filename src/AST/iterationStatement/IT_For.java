/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AST.iterationStatement;

import AST.variableTypeSpecifier.*;
import AST.conditionalExpression.*;
import AST.assignmentExpression.*;
import AST.compoundStatement.compoundStatement;
import AST.expression.*;
import app.semanticAnalysis.Table.Node;
import app.semanticAnalysis.Table.Row;
import app.semanticAnalysis.Types.FunctionType;
import app.semanticAnalysis.Types.PrimitiveDataType;
import java.util.ArrayList;

/**
 *
 * @author Daniel
 */
public class IT_For extends iterationStatement {

    private variableTypeSpecifier type;
    private String id;
    private Expression idValue;
    private conditionalExpression cE;
    private assignmentExpression aE;
    private compoundStatement stm;

    public IT_For(variableTypeSpecifier type, String id, Expression idValue, conditionalExpression cE, assignmentExpression aE, compoundStatement stm) {
        this.type = type;
        this.id = id;
        this.idValue = idValue;
        this.cE = cE;
        this.aE = aE;
        this.stm = stm;
    }

    public IT_For(String id, Expression idValue, conditionalExpression cE, assignmentExpression aE, compoundStatement stm) {
        this.type = null;
        this.id = id;
        this.idValue = idValue;
        this.cE = cE;
        this.aE = aE;
        this.stm = stm;
    }

    public variableTypeSpecifier getType() {
        return type;
    }

    public void setType(variableTypeSpecifier type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Expression getIdValue() {
        return idValue;
    }

    public void setIdValue(Expression idValue) {
        this.idValue = idValue;
    }

    public conditionalExpression getcE() {
        return cE;
    }

    public void setcE(conditionalExpression cE) {
        this.cE = cE;
    }

    public assignmentExpression getaE() {
        return aE;
    }

    public void setaE(assignmentExpression aE) {
        this.aE = aE;
    }

    public compoundStatement getStm() {
        return stm;
    }

    public void setStm(compoundStatement stm) {
        this.stm = stm;
    }

    @Override
    public void printNode() {
    }

    /*
     private variableTypeSpecifier type;
     private String id;
     private Expression idValue;
     private conditionalExpression cE;
     private assignmentExpression aE;
     private compoundStatement stm;
     */
    @Override
    public void generateSymbolNode(Node symbolNode) {
        Node novo = new Node();
        novo.setFather(symbolNode);
        symbolNode.giffBaby(novo);
        String errorMsg;
        int type1, type2, type3 = -1;
        if (this.type == null) {
            //Ya existe la variable
            if (!symbolNode.search(id)) {
                errorMsg = "Semantic Error: The id: \'" + id + "\' doesn't exists.";
                System.err.println(errorMsg);
                symbolNode.deleteLastNode();
                return;
            } else {
                //Se encontro la variable
                type1 = symbolNode.getNumericalIdType(id);
                type2 = this.idValue.getExpressionType(symbolNode);
                if (type2 == -1) { //Si hay un error de operacion
                    errorMsg = "Semantic Error: Something is wrong with the Expression.";
                    System.err.println(errorMsg);
                    symbolNode.deleteLastNode();
                    return;
                } else if (type1 != type2) {//Si no son del mismo tipo
                    reportSemanticError(type1, type2);
                    symbolNode.deleteLastNode();
                    return;
                }
                //Revisando la condicion
                ArrayList<Integer> types = this.cE.getType(symbolNode);
                if (types.size() != 1) {
                    for (Integer t : types) {
                        if (t == -1) {
                            type3 = -1;
                        } else if (t == 5) {
                            type3 = 5;
                        }
                    }
                } else if (types.size() == 1) {
                    type3 = types.get(0);
                } else {
                    type3 = -1;
                }
                //Si no es una condicion booleana
                if (type3 != 5) {
                    errorMsg = "Semantic Error: Something is wrong with the Expression, need a Boolean.";
                    symbolNode.deleteLastNode();
                    System.err.println(errorMsg);
                    return;
                }
                //Si hay un problema en el ultimo argumento
                if (!this.aE.generateSymbolNode(symbolNode)) {
                    errorMsg = "Semantic Error: Something is wrong with the assignation.";
                    System.err.println(errorMsg);
                    symbolNode.deleteLastNode();
                    return;
                } else {
                    //No hay problema en la parte de arriba
                    this.stm.generateSymbolNode(symbolNode.getSons().get(symbolNode.getSons().size() - 1));
                }

            }
        } else {
            //Se crea la variable al inicio
            int initType = this.type.getTypeAsNumber();
            if (symbolNode.getSons().get(symbolNode.getSons().size() - 1).search(id)) {
                //Ya existe una variable con ese id
                errorMsg = "Semantic Error: The id: \'" + id + "\' already exists.";
                System.err.println(errorMsg);
                symbolNode.deleteLastNode();
            } else {
                //No existe, toca verificar tipos para ver si se agrega a la tabla
                type2 = this.idValue.getExpressionType(symbolNode.getSons().get(symbolNode.getSons().size() - 1));
                if (type2 == -1) {
                    //Error de operacion
                    errorMsg = "Semantic Error: Something is wrong with the Expression.";
                    System.err.println(errorMsg);
                    symbolNode.deleteLastNode();
                    return;
                } else if (type2 == initType) {
                    //Son del mismo tipo
                    symbolNode.getSons().get(symbolNode.getSons().size() - 1).add(new Row(this.id, new PrimitiveDataType(this.objectType(initType), this.objectSize(initType))));
                    //Revisando la condicion
                    ArrayList<Integer> types = this.cE.getType(symbolNode.getSons().get(symbolNode.getSons().size() - 1));
                    if (types.size() != 1) {
                        for (Integer t : types) {
                            if (t == -1) {
                                type3 = -1;
                            } else if (t == 5) {
                                type3 = 5;
                            }
                        }
                    } else if (types.size() == 1) {
                        type3 = types.get(0);
                    } else {
                        type3 = -1;
                    }
                    //Si no es una condicion booleana
                    if (type3 != 5) {
                        errorMsg = "Semantic Error: Something is wrong with the Expression, need a Boolean.";
                        symbolNode.deleteLastNode();
                        System.err.println(errorMsg);
                        return;
                    }
                    //Si hay un problema en el ultimo argumento
                    if (!this.aE.generateSymbolNode(symbolNode.getSons().get(symbolNode.getSons().size() - 1))) {
                        errorMsg = "Semantic Error: Something is wrong with the assignation.";
                        System.err.println(errorMsg);
                        symbolNode.deleteLastNode();
                        return;
                    } else {
                        //No hay problema en la parte de arriba
                        this.stm.generateSymbolNode(symbolNode.getSons().get(symbolNode.getSons().size() - 1));
                    }
                } else {
                    //No son del mismo tipo
                    this.reportSemanticError(initType, type2);
                    symbolNode.deleteLastNode();
                    return;
                }
            }
        }

    }

    private int objectSize(int type1) {
        switch (type1) {
            case 1:
                return Character.SIZE / 8;
            case 2:
                return Integer.SIZE / 8;
            case 3:
                return Double.SIZE / 8;
            case 4:
                return 255;
            case 5:
                return 1;
            default:
                return -1;
        }
    }

    private Object objectType(int type1) {
        Object typeExpected;
        switch (type1) {
            case 1:
                typeExpected = Character.TYPE;
                break;
            case 2:
                typeExpected = Integer.TYPE;
                break;
            case 3:
                typeExpected = Double.TYPE;
                break;
            case 4:
                typeExpected = String.class.getSimpleName();
                break;
            case 5:
                typeExpected = Boolean.TYPE;
                break;
            default:
                typeExpected = null;
                break;
        }
        return typeExpected;
    }

    private void reportSemanticError(int type1, int type2) {
        String typeReceived;
        switch (type2) {
            case 1:
                typeReceived = "char";
                break;
            case 2:
                typeReceived = "int";
                break;
            case 3:
                typeReceived = "double";
                break;
            case 4:
                typeReceived = "String";
                break;
            case 5:
                typeReceived = "boolean";
                break;
            default:
                typeReceived = "Wrong Operation";
                break;
        }
        String typeExpected;
        switch (type1) {
            case 1:
                typeExpected = "char";
                break;
            case 2:
                typeExpected = "int";
                break;
            case 3:
                typeExpected = "double";
                break;
            case 4:
                typeExpected = "String";
                break;
            case 5:
                typeExpected = "boolean";
                break;
            default:
                typeExpected = "Wrong Operation";
                break;
        }
        String errorMsg = "Semantic Error: Type mismatch\n" + "\tExpected: " + typeExpected + " for the id: \'" + this.id + "\'.\n\tReceived: " + typeReceived;
        System.err.println(errorMsg);
    }

}
