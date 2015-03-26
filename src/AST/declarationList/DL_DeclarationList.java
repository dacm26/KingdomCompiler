/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AST.declarationList;
import AST.declaration.*;
/**
 *
 * @author Daniel
 */
public class DL_DeclarationList extends declarationList{
    private declarationList dL;
    private declaration d;

    public DL_DeclarationList(declarationList dL, declaration d) {
        this.dL = dL;
        this.d = d;
    }

    public declarationList getdL() {
        return dL;
    }

    public void setdL(declarationList dL) {
        this.dL = dL;
    }

    public declaration getD() {
        return d;
    }

    public void setD(declaration d) {
        this.d = d;
    }

    @Override
    public void printNode() {
        System.out.println("DL_DeclarationList");
        this.dL.printNode();
        this.d.printNode();
    }
    
}