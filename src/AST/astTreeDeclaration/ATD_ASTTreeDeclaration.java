/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AST.astTreeDeclaration;
import AST.mainFunctionDeclaration.*;
import app.semanticAnalysis.Table.*;
/**
 *
 * @author C5220701
 */
public class ATD_ASTTreeDeclaration extends astTreeDeclaration{
    private mainFunctionDeclaration mFD;
    private Node symbolNode;

    public ATD_ASTTreeDeclaration(mainFunctionDeclaration mFD) {
        this.mFD = mFD;
        this.symbolNode= new Node();
        this.generateSymbolNode();
    }

    public Node getSymbolNode() {
        return symbolNode;
    }

    public void setSymbolNode(Node symbolNode) {
        this.symbolNode = symbolNode;
    }
    

    public mainFunctionDeclaration getmFD() {
        return mFD;
    }

    public void setmFD(mainFunctionDeclaration mFD) {
        this.mFD = mFD;
    }
    @Override
    public void generateSymbolNode(){
        this.mFD.generateSymbolNode(symbolNode);
        //System.out.println(this.symbolNode.getSymbolTable().toString());
    }

    @Override
    public void printNode() {
        this.symbolNode.toString();
    }
    
}
