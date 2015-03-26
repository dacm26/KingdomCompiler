/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AST.labeledStatement;
import AST.statement.*;
/**
 *
 * @author Daniel
 */
public class LS_Default extends labeledStatement{
    private statement stm;

    public LS_Default(statement stm) {
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
        System.out.println("LS_Default");
        this.stm.printNode();
    }
    
    
}
