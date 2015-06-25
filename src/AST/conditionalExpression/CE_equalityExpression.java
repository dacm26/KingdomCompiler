/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AST.conditionalExpression;
import AST.equalityExpression.*;
import app.intermediateCode.Generate;
import app.semanticAnalysis.Table.Node;
import java.util.ArrayList;
/**
 *
 * @author Daniel
 */
public class CE_equalityExpression extends conditionalExpression{
    private equalityExpression eE;
    private String stringContent;
    private int result;
    private Generate generateCode;

    public CE_equalityExpression(equalityExpression eE) {
        this.eE = eE;
        this.setStringContent();
    }

    public equalityExpression geteE() {
        return eE;
    }

    public void seteE(equalityExpression eE) {
        this.eE = eE;
    }

    public void setStringContent(){
        if (eE instanceof EE_relationalExpression){
            EE_relationalExpression rEO = (EE_relationalExpression)eE;
            this.stringContent = rEO.getStringContent();
            this.result = rEO.getResult();
        } else {
            EE_Operation rEO = (EE_Operation)eE;
            this.stringContent = rEO.getStringContent();
            this.result = rEO.getResult();
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
        System.out.println("CE_equalityExpression");
        this.eE.printNode();
    }


    @Override
    public ArrayList<Integer> getType(Node symbolTable) {
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(this.eE.getType(symbolTable));
        return temp;
    }
    
}
