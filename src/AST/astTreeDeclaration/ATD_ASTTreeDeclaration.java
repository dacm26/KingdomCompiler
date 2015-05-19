/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AST.astTreeDeclaration;
import AST.mainFunction.MF_MainFunction;
import AST.mainFunctionDeclaration.*;
import app.semanticAnalysis.Table.*;
/**
 *
 * @author C5220701
 */
public class ATD_ASTTreeDeclaration extends astTreeDeclaration{
    private mainFunctionDeclaration mFD;
    private Table symbolTable;

    public ATD_ASTTreeDeclaration(mainFunctionDeclaration mFD) {
        this.mFD = mFD;
        this.symbolTable= new Table();
    }

    public Table getSymbolTable() {
        return symbolTable;
    }

    public void setSymbolTable(Table symbolTable) {
        this.symbolTable = symbolTable;
    }
    

    public mainFunctionDeclaration getmFD() {
        return mFD;
    }

    public void setmFD(mainFunctionDeclaration mFD) {
        this.mFD = mFD;
    }
    @Override
    public void generateSymbolTable(){
        this.mFD.generateSymbolTable(symbolTable);
        System.out.println(this.symbolTable.toString());
    }

    @Override
    public void printNode() {
        this.symbolTable.toString();
    }
    
}
