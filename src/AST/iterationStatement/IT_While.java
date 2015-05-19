/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AST.iterationStatement;
import AST.conditionalExpression.*;
import AST.compoundStatement.*;
import app.semanticAnalysis.Table.Node;
/**
 *
 * @author Daniel
 */
public class IT_While extends iterationStatement{
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
