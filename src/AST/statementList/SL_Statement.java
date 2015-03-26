/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AST.statementList;
import AST.statement.*;
/**
 *
 * @author Daniel
 */
public class SL_Statement extends statementList{
    private statement stm;

    public SL_Statement(statement stm) {
        this.stm = stm;
    }

    public statement getStm() {
        return stm;
    }

    public void setStm(statement stm) {
        this.stm = stm;
    }

    @Override
    public void printNode() {
        System.out.println("SL_Statement");
        this.stm.printNode();
    }
    
}
