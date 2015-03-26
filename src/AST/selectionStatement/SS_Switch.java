/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AST.selectionStatement;
import AST.conditionalExpression.*;
import AST.labeledStatement.*;
/**
 *
 * @author Daniel
 */
public class SS_Switch extends selectionStatement{
    private conditionalExpression cE;
    private labeledStatement lS;

    public SS_Switch(conditionalExpression cE, labeledStatement lS) {
        this.cE = cE;
        this.lS = lS;
    }

    public conditionalExpression getcE() {
        return cE;
    }

    public void setcE(conditionalExpression cE) {
        this.cE = cE;
    }

    public labeledStatement getlS() {
        return lS;
    }

    public void setlS(labeledStatement lS) {
        this.lS = lS;
    }

    @Override
    public void printNode() {
        System.out.println("SS_Switch");
        this.cE.printNode();
        this.lS.printNode();
    }
    
}
