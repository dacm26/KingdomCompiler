/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AST.mainFunctionDeclaration;
import AST.declaration.*;
/**
 *
 * @author Daniel
 */
public class MFD_Declaration extends mainFunctionDeclaration{
    private declaration d;
    private mainFunctionDeclaration mFD;

    public MFD_Declaration(declaration d, mainFunctionDeclaration mFD) {
        this.d = d;
        this.mFD = mFD;
    }

    public declaration getD() {
        return d;
    }

    public void setD(declaration d) {
        this.d = d;
    }

    public mainFunctionDeclaration getmFD() {
        return mFD;
    }

    public void setmFD(mainFunctionDeclaration mFD) {
        this.mFD = mFD;
    }

    @Override
    public void printNode() {
        System.out.println("MFD_Declaration");
        this.d.printNode();
        this.mFD.printNode();
    }
    
    
    
}
