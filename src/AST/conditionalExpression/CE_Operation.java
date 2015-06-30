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
public class CE_Operation extends conditionalExpression{
    private String stringContent;
    private int result;
    private conditionalExpression cE;
    private String operator;
    private equalityExpression eE;
    private Generate generateCode;
    private String tempInUse;
    private ArrayList<RowIC> rows;

    public CE_Operation(conditionalExpression cE, String operator, equalityExpression eE, Generate generateCode) {
        this.cE = cE;
        this.operator = operator;
        this.eE = eE;
        this.generateCode = generateCode;
        //this.generateIC();
    }

    public conditionalExpression getcE() {
        return cE;
    }

    public void setcE(conditionalExpression cE) {
        this.cE = cE;
    }

    public void setRows(ArrayList<RowIC> t){
        rows = t;
    }
    
    public void setCodeBlock(ArrayList<RowIC> t){
        rows = t;
    }

    public ArrayList<RowIC> getCodeBlock(){
        return rows;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public equalityExpression geteE() {
        return eE;
    }

    public void seteE(equalityExpression eE) {
        this.eE = eE;
    }

    @Override
    public void setStringContent(){
        stringContent = tempInUse;
    }

    @Override
    public String getStringContent(){
        return this.stringContent;
    }
    
    @Override
    public void generateIC(){
        eE.generateIC();
        cE.generateIC();
        this.tempInUse = this.generateCode.generateOperation(cE.getStringContent(), operator, eE.getStringContent());
        this.setStringContent();
    }

    @Override
    public void printNode() {
        System.out.println("CE_Operation");
        this.cE.printNode();
        System.out.println(this.operator);
        this.eE.printNode();
    }

    @Override
    public ArrayList<Integer> getType(Node symbolTable) {
        ArrayList<Integer> type1 = this.cE.getType(symbolTable);
        int type2 = this.eE.getType(symbolTable);
        type1.add(type2);
        return type1;
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
        this.cE.generateConstants(symbolNode);
        this.eE.generateConstants(symbolNode);
    }
    
}
