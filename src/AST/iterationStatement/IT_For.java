/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AST.iterationStatement;

import AST.typeSpecifier.*;
import AST.conditionalExpression.*;
import AST.assignmentExpression.*;
import AST.statement.*;

/**
 *
 * @author Daniel
 */
public class IT_For extends iterationStatement {

    private typeSpecifier type;
    private String id;
    private conditionalExpression idValue;
    private conditionalExpression cE;
    private assignmentExpression aE;
    private statement stm;

    public IT_For(typeSpecifier type, String id, conditionalExpression idValue, conditionalExpression cE, assignmentExpression aE, statement stm) {
        this.type = type;
        this.id = id;
        this.idValue = idValue;
        this.cE = cE;
        this.aE = aE;
        this.stm = stm;
    }

    public typeSpecifier getType() {
        return type;
    }

    public void setType(typeSpecifier type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public conditionalExpression getIdValue() {
        return idValue;
    }

    public void setIdValue(conditionalExpression idValue) {
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

    public statement getStm() {
        return stm;
    }

    public void setStm(statement stm) {
        this.stm = stm;
    }

    @Override
    public void printNode() {
        System.out.println("IT_For");
        this.type.printNode();
        System.out.println(this.id);
        this.idValue.printNode();
        this.cE.printNode();
        this.aE.printNode();
        this.stm.printNode();
    }

}
