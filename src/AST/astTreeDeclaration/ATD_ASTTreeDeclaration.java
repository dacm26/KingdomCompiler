/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AST.astTreeDeclaration;
import AST.mainFunctionDeclaration.*;
import app.semanticAnalysis.Table.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import app.intermediateCode.*;
/**
 *
 * @author C5220701
 */
public class ATD_ASTTreeDeclaration extends astTreeDeclaration{
    private mainFunctionDeclaration mFD;
    private Node symbolNode;
    private Generate generateCode;

    public ATD_ASTTreeDeclaration(mainFunctionDeclaration mFD) {
        this.mFD = mFD;
        this.symbolNode= new Node();
        this.generateCode = new Generate();        
        this.generateSymbolNode();
        this.generateIC();
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
    public void generateIC(){
        this.mFD.generateIC(generateCode);
        try {
            Thread.sleep(2500);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        this.generateCode.printIC();
    }
    
    @Override
    public void generateSymbolNode(){
        this.mFD.generateSymbolNode(symbolNode);
        try {
            Thread.sleep(2500);
        } catch (InterruptedException ex) {
            Logger.getLogger(ATD_ASTTreeDeclaration.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (symbolNode.error()) {
            System.err.println("Can't proceed. Check the errors.");
        }else{
            System.out.println("No sirve");
        }
        //this.generateCode.printIC();
    }

    @Override
    public void printNode() {
        this.symbolNode.toString();
    }
    
}
