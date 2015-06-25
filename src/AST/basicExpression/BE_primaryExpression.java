/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AST.basicExpression;
import AST.primaryExpression.*;
import app.intermediateCode.Generate;
import app.semanticAnalysis.Table.Node;
/**
 *
 * @author Daniel
 */
public class BE_primaryExpression extends basicExpression{
    private primaryExpression pE;
    private int result;
    private String stringContent; 
    private Generate generateCode;

    public BE_primaryExpression(primaryExpression pE) {
        this.pE = pE;
        this.setStringContent();
    }

    public primaryExpression getpE() {
        return pE;
    }

    public void setpE(primaryExpression pE) {
        this.pE = pE;
    }

    public void setStringContent(){
        if (pE instanceof PE_Content){
            PE_Content pEC = (PE_Content)pE;
            this.stringContent = pEC.stringContent();
            this.result = Integer.MAX_VALUE;
        } else if (pE instanceof PE_Id) {
            PE_Id pEI = (PE_Id)pE;
            this.stringContent = pEI.getId();
            this.result = Integer.MAX_VALUE;
        } else {
            PE_Expression pEE = (PE_Expression)pE;
            this.stringContent = pEE.getStringContent();
            this.result = pEE.getResult();
        }
    }

    public String getStringContent(){
        return this.stringContent;
    }

    public int getResult(){
        return result;
    }
    
    @Override
    public void generateIC(Generate gc){
        this.generateCode = gc;
    }

    @Override
    public void printNode() {
        System.out.println("BE_primaryExpression");
        this.pE.printNode();
    }

    @Override
    public int getType(Node symbolTable) {
        return this.pE.getType(symbolTable);
    }

    
}
