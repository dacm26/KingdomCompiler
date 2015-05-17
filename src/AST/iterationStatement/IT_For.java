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

}
