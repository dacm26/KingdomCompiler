/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AST.assignmentExpression;

import AST.Expression.*;
import AST.variableTypeSpecifier.*;
/**
 *
 * @author Daniel
 */
public class AE_Assignation extends assignmentExpression{
    private variableTypeSpecifier vTS;
    private String id;
    private String operator;
    private Expression exp;

    public AE_Assignation(variableTypeSpecifier vTS, String id, Expression exp) {
        this.vTS = vTS;
        this.id = id;
        this.operator="=";
        this.exp = exp;
    }

    public AE_Assignation(String id, Expression exp) {
        this.vTS = null;
        this.id = id;
        this.operator = "=";
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

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
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
    
    
    
}
