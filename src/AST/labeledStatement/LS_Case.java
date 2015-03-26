/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AST.labeledStatement;
import AST.conditionalExpression.*;
import AST.statement.*;
/**
 *
 * @author Daniel
 */
public class LS_Case extends labeledStatement{
    private conditionalExpression cE;
    private statement stm;
    private labeledStatement lS;

    public LS_Case(conditionalExpression cE, statement stm, labeledStatement lS) {
        this.cE = cE;
        this.stm = stm;
        this.lS = lS;
    }
    public conditionalExpression getcE() {
        return cE;
    }

    public void setcE(conditionalExpression cE) {
        this.cE = cE;
    }

    public statement getStm() {
        return stm;
    }

    public void setStm(statement stm) {
        this.stm = stm;
    }

    public labeledStatement getlS() {
        return lS;
    }

    public void setlS(labeledStatement lS) {
        this.lS = lS;
    }

    @Override
    public void printNode() {
        System.out.println("LS_Case");
        this.cE.printNode();
        this.stm.printNode();
        this.lS.printNode();
    }
    
}
