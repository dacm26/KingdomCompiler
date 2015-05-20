/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AST.declaration;

import AST.expression.Expression;
import AST.variableTypeSpecifier.*;
import app.semanticAnalysis.Table.Node;
import app.semanticAnalysis.Table.Row;
import app.semanticAnalysis.Types.PrimitiveDataType;

/**
 *
 * @author Daniel
 */
public class D_Assign extends Declaration {

    private variableTypeSpecifier type;
    private String id;
    private Expression exp;

    public D_Assign(String id, Expression exp) {
        this.type = null;
        this.id = id;
        this.exp = exp;
    }

    public D_Assign(variableTypeSpecifier type, String id, Expression exp) {
        this.type = type;
        this.id = id;
        this.exp = exp;
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
    public void printNode() {
    }

    @Override
    public void generateSymbolNode(Node symbolNode) {
        int type1;
        int type2;

        /*Falta comprobacion de tipos*/
        if (this.type == null) {
            /*Es una asignacion de una variable ya creada*/
            String typeTemp = symbolNode.getSymbolTable().getIdType(id).toString();
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
                if (type2 == 0 || (type1 == type2)) {
                    return;
                } else {
                    System.err.println("Error, Type mismatch (D_Assign2)");
                }
            }
        } else {
            /*Es una declaracion de variable con su respectiva asignacion*/
            type1 = this.type.getTypeAsNumber();
            type2 = this.exp.getExpressionType(symbolNode);
            if (type2 == -1) {
                System.err.println("Error, Type mismatch (D_Assign3)");
            } else {
                if (type2 == 0 || (type1 == type2)) {
                    symbolNode.getSymbolTable().add(new Row(id, new PrimitiveDataType(((VTS_Type) this.type).getType(), ((VTS_Type) this.type).getSize())));
                } else {
                    System.err.println("Error, Type mismatch (D_Assign4)");
                }
            }
            

        }
    }

}
