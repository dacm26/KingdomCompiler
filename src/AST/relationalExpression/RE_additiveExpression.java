/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AST.relationalExpression;
import AST.additiveExpression.*;
import app.intermediateCode.Generate;
import app.semanticAnalysis.Table.Node;
/**
 *
 * @author Daniel
 */
public class RE_additiveExpression extends relationalExpression{
    private additiveExpression aE;
    private String stringContent;
    private int result;
    private Generate generateCode;

    public RE_additiveExpression(additiveExpression aE, Generate generateCode) {
        this.aE = aE;
        this.generateCode = generateCode;
        this.setStringContent();
    }

    public additiveExpression getaE() {
        return aE;
    }

    public void setaE(additiveExpression aE) {
        this.aE = aE;
    }
    
    @Override
    public void setStringContent(){
        if (aE instanceof AE_Operation){
            AE_Operation aEO = (AE_Operation)aE;
            this.stringContent = aEO.getStringContent();
        } else {
            AE_multiplicativeExpression aEM = (AE_multiplicativeExpression)aE;
            this.stringContent = aEM.getStringContent();
        }
    }

    @Override
    public String getStringContent(){
        return this.stringContent;
    }

    @Override
    public void generateIC(){
    }

    @Override
    public void printNode() {
        System.out.println("RE_additiveExpression");
        this.aE.printNode();
    }


    @Override
    public int getType(Node symbolTable) {
        return this.aE.getType(symbolTable);
    }
    
    
}
