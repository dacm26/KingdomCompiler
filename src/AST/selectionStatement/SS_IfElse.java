/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AST.selectionStatement;

import AST.conditionalExpression.*;
import AST.compoundStatement.*;
import app.semanticAnalysis.Table.Node;

/**
 *
 * @author Daniel
 */
public class SS_IfElse extends selectionStatement {

    private conditionalExpression cE;
    private compoundStatement stmIf;
    private compoundStatement stmElse;

    public SS_IfElse(conditionalExpression cE, compoundStatement stmIf, compoundStatement stmElse) {
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

    public compoundStatement getStmIf() {
        return stmIf;
    }

    public void setStmIf(compoundStatement stmIf) {
        this.stmIf = stmIf;
    }

    public compoundStatement getStmElse() {
        return stmElse;
    }

    public void setStmElse(compoundStatement stmElse) {
        this.stmElse = stmElse;
    }

    @Override
    public void printNode() {
        System.out.println("SS_IfElse");
        this.cE.printNode();
        this.stmIf.printNode();
        this.stmElse.printNode();
    }

    @Override
    public void generateSymbolNode(Node symbolNode) {
        
    }
    
}
