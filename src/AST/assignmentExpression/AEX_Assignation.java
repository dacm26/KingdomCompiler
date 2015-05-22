/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AST.assignmentExpression;

import AST.expression.*;
import AST.variableTypeSpecifier.*;
import app.semanticAnalysis.Table.Node;

/**
 *
 * @author Daniel
 */
public class AEX_Assignation extends assignmentExpression {

    private variableTypeSpecifier vTS;
    private String id;
    private Expression exp;

    public AEX_Assignation(variableTypeSpecifier vTS, String id, Expression exp) {
        this.vTS = vTS;
        this.id = id;
        this.exp = exp;
    }

    public AEX_Assignation(String id, Expression exp) {
        this.vTS = null;
        this.id = id;
        this.exp = exp;
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

    public Expression getExp() {
        return exp;
    }

    public void setExp(Expression exp) {
        this.exp = exp;
    }

    @Override
    public void printNode() {
    }

    @Override
    public boolean generateSymbolNode(Node symbolNode) {
        
        int type1, type2;
        String errorMsg;
        if (this.vTS == null) {
            //La variable ya existe
            type1 = symbolNode.getNumericalIdType(this.id);
            if (type1 == -1) {
                //No se encuentra la variable
                errorMsg = "Semantic Error: The id: \'" + id + "\' doesn't exists.";
                System.err.println(errorMsg);
                return false;
            } else {
                //Se encontro la variable
                type2 = this.exp.getExpressionType(symbolNode);
                if (type2 == -1) {
                    //Error en la expression
                    errorMsg = "Semantic Error: Something is wrong with the expression.";
                    System.err.println(errorMsg);
                    return false;
                } else if (type1 != type2) {
                    //No son del mismo tipo
                    reportSemanticError(type1, type2);
                    return false;
                } else {
                    //Todo suave
                    return true;
                }
            }

        } else {
            errorMsg = "Semantic Error: You can't create a variable there!";
            System.err.println(errorMsg);
            return false;
        }
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
