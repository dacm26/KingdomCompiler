/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AST.declaration;
import AST.typeSpecifier.*;
import AST.identifierList.*;
/**
 *
 * @author Daniel
 */
public class D_identifierList extends declaration{
    private typeSpecifier tS;
    private identifierList iL;

    public D_identifierList(typeSpecifier tS, identifierList iL) {
        this.tS = tS;
        this.iL = iL;
    }

    public typeSpecifier gettS() {
        return tS;
    }

    public void settS(typeSpecifier tS) {
        this.tS = tS;
    }

    public identifierList getiL() {
        return iL;
    }

    public void setiL(identifierList iL) {
        this.iL = iL;
    }

    @Override
    public void printNode() {
        System.out.println("D_identifierList");
        this.tS.printNode();
        this.iL.printNode();
    }
    
}
