/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AST.selectionStatement;

import AST.conditionalExpression.*;
import AST.compoundStatement.*;
import app.semanticAnalysis.Table.Node;
import java.util.ArrayList;

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

        int type1;
        String errorMsg = "Semantic Error: Something is wrong with the expression.";
        ArrayList<Integer> types = this.cE.getType(symbolNode);
        if (types.size() != 1) {
            for (Integer type : types) {
                if (type == -1) {
                    System.err.println(errorMsg);
                    return;
                } else if (type == 5) {
                    type1 = 5;
                }
            }

        } else if (types.size() == 1) {
            type1 = types.get(0);
        } else {
            System.err.println(errorMsg);
            return;
        }
        Node novo = new Node();
        novo.setFather(symbolNode);
        symbolNode.giffBaby(novo);
        this.stmIf.generateSymbolNode(symbolNode.getSons().get(symbolNode.getSons().size() - 1));
        Node novoElse = new Node();
        novoElse.setFather(symbolNode);
        symbolNode.giffBaby(novoElse);
        this.stmElse.generateSymbolNode(symbolNode.getSons().get(symbolNode.getSons().size() - 1));
    }

}
