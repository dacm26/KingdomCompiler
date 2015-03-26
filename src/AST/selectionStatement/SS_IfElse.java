/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AST.selectionStatement;

import AST.conditionalExpression.*;
import AST.statement.*;

/**
 *
 * @author Daniel
 */
public class SS_IfElse extends selectionStatement {

    private conditionalExpression cE;
    private statement stmIf;
    private statement stmElse;

    public SS_IfElse(conditionalExpression cE, statement stmIf, statement stmElse) {
        this.cE = cE;
        this.stmIf = stmIf;
        this.stmElse = stmElse;
    }

    public conditionalExpression getcE() {
        return cE;
    }

    public void setcE(conditionalExpression cE) {
        this.cE = cE;
    }

    public statement getStmIf() {
        return stmIf;
    }

    public void setStmIf(statement stmIf) {
        this.stmIf = stmIf;
    }

    public statement getStmElse() {
        return stmElse;
    }

    public void setStmElse(statement stmElse) {
        this.stmElse = stmElse;
    }

    @Override
    public void printNode() {
        System.out.println("SS_IfElse");
        this.cE.printNode();
        this.stmIf.printNode();
        this.stmElse.printNode();
    }
    
}
