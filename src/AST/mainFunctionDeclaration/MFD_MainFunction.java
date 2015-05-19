/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AST.mainFunctionDeclaration;
import AST.mainFunction.*;
import AST.externalDeclaration.*;
import app.semanticAnalysis.Table.Table;
/**
 *
 * @author Daniel
 */
public class MFD_MainFunction extends mainFunctionDeclaration{
    private mainFunction mF;
    private externalDeclaration eD;

    public MFD_MainFunction(mainFunction mF, externalDeclaration eD) {
        this.mF = mF;
        this.eD = eD;
    }

    public mainFunction getmF() {
        return mF;
    }

    public void setmF(mainFunction mF) {
        this.mF = mF;
    }

    public externalDeclaration geteD() {
        return eD;
    }

    public void seteD(externalDeclaration eD) {
        this.eD = eD;
    }

    @Override
    public void printNode() {
        System.out.println("MFD_MainFunction");
        this.mF.printNode();
        this.eD.printNode();
    }

    @Override
    public void generateSymbolTable(Table symbolTable) {
        this.mF.generateSymbolTable(symbolTable);
        //Falta implementarlo
        //this.eD.generateSymbolTable(symbolTable);
    }
    
}
