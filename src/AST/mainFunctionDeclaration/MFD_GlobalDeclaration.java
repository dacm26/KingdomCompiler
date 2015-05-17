/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AST.mainFunctionDeclaration;
import AST.globalDeclaration.globalDeclaration;
/**
 *
 * @author Daniel
 */
public class MFD_GlobalDeclaration extends mainFunctionDeclaration{
    private globalDeclaration d;
    private mainFunctionDeclaration mFD;

    public MFD_GlobalDeclaration(globalDeclaration d, mainFunctionDeclaration mFD) {
        this.d = d;
        this.mFD = mFD;
    }

    public globalDeclaration getD() {
        return d;
    }

    public void setD(globalDeclaration d) {
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

    }
    
    
    
}
