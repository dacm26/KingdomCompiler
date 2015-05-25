/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AST.mainFunctionDeclaration;
import AST.mainFunction.*;
import app.semanticAnalysis.Table.Node;
/**
 *
 * @author Daniel
 */
public class MFD_MainFunction extends mainFunctionDeclaration{
    private mainFunction mF;

    public MFD_MainFunction(mainFunction mF) {
        this.mF = mF;
    }

    public mainFunction getmF() {
        return mF;
    }

    public void setmF(mainFunction mF) {
        this.mF = mF;
    }



    @Override
    public void printNode() {
    }

    @Override
    public void generateSymbolNode(Node symbolNode) {

        this.mF.generateSymbolNode(symbolNode);
    }
    
}
