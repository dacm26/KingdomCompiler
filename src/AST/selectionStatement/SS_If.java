/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AST.selectionStatement;
import AST.conditionalExpression.*;
import AST.statement.*;
/**
 *
 * @author Daniel
 */
public class SS_If extends selectionStatement{
    private conditionalExpression cE;
    private statement stm;

    public SS_If(conditionalExpression cE, statement stm) {
        this.cE = cE;
        this.stm = stm;
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

    @Override
    public void printNode() {
        System.out.println("SS_If");
        this.cE.printNode();
        this.stm.printNode();
    }
    
    
}