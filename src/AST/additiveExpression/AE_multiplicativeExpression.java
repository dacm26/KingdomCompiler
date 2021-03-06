/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AST.additiveExpression;
import AST.multiplicativeExpression.*;
import app.intermediateCode.Generate;
import app.semanticAnalysis.Table.Node;
/**
 *
 * @author Daniel
 */
public class AE_multiplicativeExpression extends additiveExpression{
    private multiplicativeExpression mE;
    private String stringContent;
    private int result;
    private Generate generateCode;

    public AE_multiplicativeExpression(multiplicativeExpression mE) {
        this.mE = mE;
//        this.setStringContent();
    }

    public multiplicativeExpression getbE() {
        return mE;
    }

    public void setbE(multiplicativeExpression mE) {
        this.mE = mE;
    }

    public void setStringContent(){
        if (mE instanceof ME_basicExpression){
            ME_basicExpression mEB = (ME_basicExpression)mE;
            this.stringContent = mEB.getStringContent();
            this.result = mEB.getResult();
        } else {
            ME_Operation mEO = (ME_Operation)mE;
            this.stringContent = mEO.getStringContent();
            this.result = mEO.getResult();
        }
    }

    public int getResult(){
        return result;
    }

    public String getStringContent(){
        return this.stringContent;
    }
    
    @Override
    public void generateIC(Generate gc){
        this.generateCode = gc;
    }

    @Override
    public void printNode() {
        System.out.println("AE_multiplicativeExpression");
        this.mE.printNode();
    }


    @Override
    public int getType(Node symbolTable) {
        return this.mE.getType(symbolTable);
    }
    
}
