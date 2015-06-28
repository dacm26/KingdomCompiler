/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AST.selectionStatement;

import AST.compoundStatement.compoundStatement;
import AST.conditionalExpression.conditionalExpression;
import app.semanticAnalysis.Table.Node;
import java.util.ArrayList;

/**
 *
 * @author Daniel
 */
public class SS_IfSS extends selectionStatement {

    private conditionalExpression cE;
    private compoundStatement cS;
    private selectionStatement sS;

    public SS_IfSS(conditionalExpression cE, compoundStatement cS, selectionStatement sS) {
        this.cE = cE;
        this.cS = cS;
        this.sS = sS;
    }

    public conditionalExpression getcE() {
        return cE;
    }

    public void setcE(conditionalExpression cE) {
        this.cE = cE;
    }

    public compoundStatement getcS() {
        return cS;
    }

    public void setcS(compoundStatement cS) {
        this.cS = cS;
    }

    public selectionStatement getsS() {
        return sS;
    }

    public void setsS(selectionStatement sS) {
        this.sS = sS;
    }

    @Override
    public void printNode() {
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
        this.cS.generateSymbolNode(symbolNode.getSons().get(symbolNode.getSons().size() - 1));
        this.sS.generateSymbolNode(symbolNode);
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