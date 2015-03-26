/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AST.mainFunctionDefinition;
import AST.declaration.*;
/**
 *
 * @author Daniel
 */
public class MFD_Declaration extends mainFunctionDefinition{
    private declaration d;
    private mainFunctionDefinition mFD;

    public MFD_Declaration(declaration d, mainFunctionDefinition mFD) {
        this.d = d;
        this.mFD = mFD;
    }

    public declaration getD() {
        return d;
    }

    public void setD(declaration d) {
        this.d = d;
    }

    public mainFunctionDefinition getmFD() {
        return mFD;
    }

    public void setmFD(mainFunctionDefinition mFD) {
        this.mFD = mFD;
    }

    @Override
    public void printNode() {
        System.out.println("MFD_Declaration");
        this.d.printNode();
        this.mFD.printNode();
    }
    
    
    
}
