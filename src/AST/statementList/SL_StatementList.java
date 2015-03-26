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
public class SL_StatementList extends statementList{
    private statementList sL;
    private statement stm;

    public SL_StatementList(statementList sL, statement stm) {
        this.sL = sL;
        this.stm = stm;
    }

    public statementList getsL() {
        return sL;
    }

    public void setsL(statementList sL) {
        this.sL = sL;
    }

    public statement getStm() {
        return stm;
    }

    public void setStm(statement stm) {
        this.stm = stm;
    }

    @Override
    public void printNode() {
        System.out.println("SL_StatementList");
        this.sL.printNode();
        this.stm.printNode();
    }
    
    
}
