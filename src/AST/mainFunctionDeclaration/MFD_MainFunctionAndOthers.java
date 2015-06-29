/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AST.mainFunctionDeclaration;

import AST.functionDefinition.functionDefinition;
import app.intermediateCode.Generate;
import app.semanticAnalysis.Table.Node;

/**
 *
 * @author C5220701
 */
public class MFD_MainFunctionAndOthers extends mainFunctionDeclaration{
    private functionDefinition fD;
    private mainFunctionDeclaration mFD;
    private Generate generateCode;

    public MFD_MainFunctionAndOthers(functionDefinition fD, mainFunctionDeclaration mFD, Generate generateCode) {
        this.fD = fD;
        this.mFD = mFD;
        this.generateCode = generateCode;
    }

    public functionDefinition getfD() {
        return fD;
    }

    public void setfD(functionDefinition fD) {
        this.fD = fD;
    }

    public mainFunctionDeclaration getmFD() {
        return mFD;
    }

    public void setmFD(mainFunctionDeclaration mFD) {
        this.mFD = mFD;
    }
    
    @Override
    public void generateIC(){
        this.mFD.generateIC();
        this.fD.generateIC();
    }

    @Override
    public void printNode() {
    }

    @Override
    public void generateSymbolNode(Node symbolNode) {
        /**/
        this.fD.generateSymbolNode(symbolNode);
        this.mFD.generateSymbolNode(symbolNode);
    }
    
}
