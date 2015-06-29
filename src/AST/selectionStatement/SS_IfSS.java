/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AST.selectionStatement;

import AST.compoundStatement.compoundStatement;
import AST.conditionalExpression.conditionalExpression;
import app.intermediateCode.Generate;
import app.intermediateCode.RowIC;
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
    private Generate generateCode;
    private ArrayList<RowIC> cER;

    public SS_IfSS(conditionalExpression cE, compoundStatement cS, selectionStatement sS, Generate generateCode) {
        this.cE = cE;
        this.cS = cS;
        this.sS = sS;
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
    public void generateIC(){
        this.generateCode.flushCodeBlock(cE.getCodeBlock());
        String tag = generateCode.generateTag();
        this.generateCode.generateIfStatement(cE.getStringContent(),tag,cS,null,sS);
    }

    @Override
    public void printNode() {
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
}
