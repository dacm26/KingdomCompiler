/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AST.selectionStatement;

import AST.compoundStatement.compoundStatement;
import AST.conditionalExpression.conditionalExpression;
import app.semanticAnalysis.Table.Node;

/**
 *
 * @author Daniel
 */
public class SS_IfSS extends selectionStatement{
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
