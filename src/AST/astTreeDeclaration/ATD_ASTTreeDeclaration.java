/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AST.astTreeDeclaration;
import AST.mainFunctionDeclaration.*;
/**
 *
 * @author C5220701
 */
public class ATD_ASTTreeDeclaration extends astTreeDeclaration{
    private mainFunctionDeclaration mFD;

    public ATD_ASTTreeDeclaration(mainFunctionDeclaration mFD) {
        this.mFD = mFD;
    }

    public mainFunctionDeclaration getmFD() {
        return mFD;
    }

    public void setmFD(mainFunctionDeclaration mFD) {
        this.mFD = mFD;
    }

    @Override
    public void printNode() {
        System.out.println("ATD_ASTTreeDeclaration");
        this.mFD.printNode();
    }
    
}
