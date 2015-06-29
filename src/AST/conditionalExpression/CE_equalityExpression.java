/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AST.conditionalExpression;
import AST.equalityExpression.*;
import app.intermediateCode.*;
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
    private ArrayList<Row> row;

    public CE_equalityExpression(equalityExpression eE, Generate generateCode) {
        this.generateCode = generateCode;
        this.eE = eE;
        this.setStringContent();
        this.row = new ArrayList<>();
    }

    public equalityExpression geteE() {
        return eE;
    }

    public void seteE(equalityExpression eE) {
        this.eE = eE;
    }

    public ArrayList<Row> getCodeBlock(){
        return row;
    }

    public void setCodeBlock(ArrayList<Row> t){
        row = t;
    }

    @Override
    public void setStringContent(){
        if (eE instanceof EE_relationalExpression){
            EE_relationalExpression rEO = (EE_relationalExpression)eE;
            this.stringContent = rEO.getStringContent();
        } else {
            EE_Operation rEO = (EE_Operation)eE;
            this.stringContent = rEO.getStringContent();
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
