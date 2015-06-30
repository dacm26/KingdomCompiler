/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AST.iterationStatement;

import AST.conditionalExpression.*;
import AST.compoundStatement.*;
import app.semanticAnalysis.Table.Node;
import java.util.ArrayList;

/**
 *
 * @author Daniel
 */
public class IT_While extends iterationStatement {

    private conditionalExpression cE;
    private compoundStatement stm;

    public IT_While(conditionalExpression cE, compoundStatement stm) {
        this.cE = cE;
        this.stm = stm;
    }

    public conditionalExpression getcE() {
        return cE;
    }

    public void setcE(conditionalExpression cE) {
        this.cE = cE;
    }

    public compoundStatement getStm() {
        return stm;
    }

    public void setStm(compoundStatement stm) {
        this.stm = stm;
    }

    @Override
    public void printNode() {
        System.out.println("IT_While");
        this.cE.printNode();
        this.stm.printNode();
    }

    @Override
    public void generateSymbolNode(Node symbolNode) {
        int type1;
        String errorMsg = "Semantic Error: Something is wrong with the expression."+"\n\tline: "+this.line;
        ArrayList<Integer> types = this.cE.getType(symbolNode);
        if (types.size() != 1) {
            for (Integer type : types) {
                if (type == -1) {
                    System.err.println(errorMsg);
                    symbolNode.setErrors();
                    return;
                } else if (type == 5) {
                    type1 = 5;
                }
            }

        } else if (types.size() == 1) {
            type1 = types.get(0);
        } else {
            System.err.println(errorMsg);
            symbolNode.setErrors();
            return;
        }
        Node novo = new Node();
        novo.setFather(symbolNode);
        symbolNode.giffBaby(novo);
        this.stm.generateSymbolNode(symbolNode.getSons().get(symbolNode.getSons().size()-1));
        
    }

@Override
    public void setLine(int line) {
        this.line = line+1;
    }

    @Override
    public int getLine() {
        return this.line;
    }
    
}