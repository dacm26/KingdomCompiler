/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AST.mainFunction;
import AST.typeSpecifier.*;
import AST.mainDeclarator.*;
import AST.compoundStatement.*;
/**
 *
 * @author Daniel
 */
public class MF_MainFunction extends mainFunction{
    private typeSpecifier tS;
    private mainDeclarator mD;
    private compoundStatement cS;

    public MF_MainFunction(typeSpecifier tS, mainDeclarator mD, compoundStatement cS) {
        this.tS = tS;
        this.mD = mD;
        this.cS = cS;
    }

    public typeSpecifier gettS() {
        return tS;
    }

    public void settS(typeSpecifier tS) {
        this.tS = tS;
    }

    public mainDeclarator getmD() {
        return mD;
    }

    public void setmD(mainDeclarator mD) {
        this.mD = mD;
    }

    public compoundStatement getcS() {
        return cS;
    }

    public void setcS(compoundStatement cS) {
        this.cS = cS;
    }

    @Override
    public void printNode() {
        System.out.println("MF_MainFunction");
        this.tS.printNode();
        this.mD.printNode();
        this.cS.printNode();
    }
    
}
