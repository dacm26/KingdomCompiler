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
public class CE_Operation extends conditionalExpression{
    private conditionalExpression cE;
    private String operator;
    private equalityExpression eE;
    private Generate generateCode;

    public CE_Operation(conditionalExpression cE, String operator, equalityExpression eE) {
        this.cE = cE;
        this.operator = operator;
        this.eE = eE;
    }

    public conditionalExpression getcE() {
        return cE;
    }

    public void setcE(conditionalExpression cE) {
        this.cE = cE;
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
    public void generateIC(Generate gc){
        this.generateCode = gc;
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
    
}
