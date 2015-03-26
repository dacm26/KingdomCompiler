/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AST.compoundStatement;
import AST.statementList.*;
import AST.declarationList.*;
/**
 *
 * @author Daniel
 */
public class CS_Compound extends compoundStatement{
    private statementList sL;
    private declarationList dL;

    public CS_Compound(declarationList dL,statementList sL) {
        this.sL = sL;
        this.dL = dL;
    }

    public statementList getsL() {
        return sL;
    }

    public void setsL(statementList sL) {
        this.sL = sL;
    }

    public declarationList getdL() {
        return dL;
    }

    public void setdL(declarationList dL) {
        this.dL = dL;
    }

    @Override
    public void printNode() {
        System.out.println("CS_Compound");
        this.dL.printNode();
        this.sL.printNode();
    }
    
}
