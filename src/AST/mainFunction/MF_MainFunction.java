/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AST.mainFunction;
import AST.functionTypeSpecifier.*;
import AST.compoundStatement.*;
/**
 *
 * @author Daniel
 */
public class MF_MainFunction extends mainFunction{
    private functionTypeSpecifier tS;
    private compoundStatement cS;

    public MF_MainFunction(functionTypeSpecifier tS, compoundStatement cS) {
        this.tS = tS;
        this.cS = cS;
    }

    public functionTypeSpecifier gettS() {
        return tS;
    }

    public void settS(functionTypeSpecifier tS) {
        this.tS = tS;
    }


    public compoundStatement getcS() {
        return cS;
    }

    public void setcS(compoundStatement cS) {
        this.cS = cS;
    }

    @Override
    public void printNode() {
    }
    
}
