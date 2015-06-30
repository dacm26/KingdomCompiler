/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AST.equalityExpression;
import AST.relationalExpression.*;
import app.intermediateCode.Generate;
import app.semanticAnalysis.Table.Node;
/**
 *
 * @author Daniel
 */
public class EE_relationalExpression extends equalityExpression{
    private relationalExpression rE;
    private String stringContent;
    private int result;
    private Generate generateCode;

    public EE_relationalExpression(relationalExpression rE, Generate generateCode) {
        this.rE = rE;
        this.generateCode = generateCode;
        this.setStringContent();
    }

    public relationalExpression getrE() {
        return rE;
    }

    public void setrE(relationalExpression rE) {
        this.rE = rE;
    }

    @Override
    public void setStringContent(){
        if (rE instanceof RE_additiveExpression){
            RE_additiveExpression rEO = (RE_additiveExpression)rE;
            this.stringContent = rEO.getStringContent();
        } else {
            RE_Operation rEO = (RE_Operation)rE;
            this.stringContent = rEO.getStringContent();
        }
    }

    @Override
    public String getStringContent(){
        return this.stringContent;
    }

    @Override
    public void generateIC(){
        rE.generateIC();
        this.setStringContent();
    }
    
    @Override
    public void printNode() {
        System.out.println("EE_relationalExpression");
        this.rE.printNode();
    }

    @Override
    public int getType(Node symbolTable) {
        return this.rE.getType(symbolTable);
    }


    
@Override
    public void setLine(int line) {
        this.line = line+1;
    }

    @Override
    public int getLine() {
        return this.line;
    }

    @Override
    public void generateConstants(Node symbolNode) {
        this.rE.generateConstants(symbolNode);
    }
    
}
