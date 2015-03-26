/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AST.compoundStatement;
import AST.declarationList.*;
/**
 *
 * @author Daniel
 */
public class CS_DeclarationList extends compoundStatement{
    private declarationList dL;

    public CS_DeclarationList(declarationList dL) {
        this.dL = dL;
    }

    public declarationList getsL() {
        return dL;
    }

    public void setsL(declarationList dL) {
        this.dL = dL;
    }

    @Override
    public void printNode() {
        System.out.println("CS_DeclarationList");
        this.dL.printNode();
    }
    
    
}
