/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AST.mainFunctionDeclaration;
import AST.mainFunction.*;
import app.semanticAnalysis.Table.Node;
import app.intermediateCode.Generate;
/**
 *
 * @author Daniel
 */
public class MFD_MainFunction extends mainFunctionDeclaration{
    private mainFunction mF;
    private Generate generateCode;

    public MFD_MainFunction(mainFunction mF, Generate generateCode) {
        this.mF = mF;
        this.generateCode = generateCode;
    }

    public mainFunction getmF() {
        return mF;
    }

    public void setmF(mainFunction mF) {
        this.mF = mF;
    }

    @Override
    public void generateIC(){
        this.generateCode.generateTag("main:");
        this.mF.generateIC();
    }

    @Override
    public void printNode() {
    }

    @Override
    public void generateSymbolNode(Node symbolNode) {
        this.mF.generateSymbolNode(symbolNode);
    }
    
}
