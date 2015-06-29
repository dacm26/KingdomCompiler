/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AST.selectionStatement;

import AST.conditionalExpression.*;
import AST.compoundStatement.*;
import app.intermediateCode.*;
import app.semanticAnalysis.Table.Node;
import java.util.ArrayList;

/**
 *
 * @author Daniel
 */
public class SS_If extends selectionStatement {

    private conditionalExpression cE;
    private compoundStatement stm;
    private Generate generateCode;
    private ArrayList<RowIC> cER;

    public SS_If(conditionalExpression cE, compoundStatement stm, Generate generateCode) {
        this.cE = cE;
        this.stm = stm;
        this.generateCode = generateCode;
        cE.generateIC();
        this.cER = new ArrayList<RowIC>(this.generateCode.getCodeBlock());
        this.generateCode.emptyTemp();
        this.cE.setCodeBlock(cER);
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
    public void generateIC(){
        this.generateCode.flushCodeBlock(cE.getCodeBlock());
        String tag = generateCode.generateTag();
        this.generateCode.generateIfStatement(cE.getStringContent(),tag,stm,null);
    }

    @Override
    public void printNode() {
        System.out.println("SS_If");
        this.cE.printNode();
        this.stm.printNode();
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
        this.stm.generateSymbolNode(symbolNode.getSons().get(symbolNode.getSons().size() - 1));
    }

}
