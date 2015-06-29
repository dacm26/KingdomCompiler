/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AST.declaration;

import AST.expression.Expression;
import AST.variableTypeSpecifier.*;
import app.intermediateCode.Generate;
import app.intermediateCode.RowIC;
import app.semanticAnalysis.Table.Node;
import app.semanticAnalysis.Table.Row;
import app.semanticAnalysis.Types.PrimitiveDataType;
import java.util.ArrayList;

/**
 *
 * @author Daniel
 */
public class D_Assign extends Declaration {

    private variableTypeSpecifier type;
    private Generate generateCode;
    private String id;
    private Expression exp;
    private ArrayList<RowIC> cER;

    public D_Assign(String id, Expression exp, Generate generateCode) {
        this.type = null;
        this.id = id;
        this.exp = exp;
        this.generateCode = generateCode;
        exp.generateIC();
        this.cER = new ArrayList<RowIC>(this.generateCode.getCodeBlock());
        this.generateCode.emptyTemp();
        this.exp.setCodeBlock(cER);
    }

    public D_Assign(variableTypeSpecifier type, String id, Expression exp, Generate generateCode) {
        this.type = type;
        this.id = id;
        this.exp = exp;
        this.generateCode = generateCode;
        exp.generateIC();
        this.cER = new ArrayList<RowIC>(this.generateCode.getCodeBlock());
        this.generateCode.emptyTemp();
        this.exp.setCodeBlock(cER);
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

    public Expression getExp() {
        return exp;
    }

    public void setExp(Expression exp) {
        this.exp = exp;
    }

    @Override
    public void generateIC() {
        this.generateCode.flushCodeBlock(exp.getCodeBlock());
        this.generateCode.generateAssign(this.id, this.exp.getStringContent());
    }

    @Override
    public void printNode() {
    }

    @Override
    public void generateSymbolNode(Node symbolNode) {
        int type1;
        int type2;

        if (this.type == null) {
            /*Es una asignacion de una variable ya creada*/
            String typeTemp = symbolNode.getIdType(id).toString();
            switch (typeTemp) {
                case "int":
                    type1 = 2;
                    break;
                case "char":
                    type1 = 1;
                    break;
                case "double":
                    type1 = 3;
                    break;
                case "boolean":
                    type1 = 5;
                    break;
                case "String":
                    type1 = 4;
                    break;
                default:
                    type1 = -1;
            }
            if (type1 == -1) {
                System.err.println("Error, Type mismatch (D_Assign1)");
            } else {
                type2 = this.exp.getExpressionType(symbolNode);
                if ((type1 == type2)) {
                } else {
                    reportSemanticError(type1, type2);
                }
            }
        } else {
            /*Es una declaracion de variable con su respectiva asignacion*/
            type1 = this.type.getTypeAsNumber();
            type2 = this.exp.getExpressionType(symbolNode);
            if (type2 == -1) {
                reportSemanticError(type1, type2);
            } else {
                if ((type1 == type2)) {
                    symbolNode.add(new Row(id, new PrimitiveDataType(((VTS_Type) this.type).getType(), ((VTS_Type) this.type).getSize()), false));
                } else {
                    reportSemanticError(type1, type2);
                }
            }

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
