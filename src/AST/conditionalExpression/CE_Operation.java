/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AST.conditionalExpression;
import AST.equalityExpression.*;
import app.semanticAnalysis.Table.Node;
/**
 *
 * @author Daniel
 */
public class CE_Operation extends conditionalExpression{
    private conditionalExpression cE;
    private String operator;
    private equalityExpression eE;

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
    public void printNode() {
        System.out.println("CE_Operation");
        this.cE.printNode();
        System.out.println(this.operator);
        this.eE.printNode();
    }

    @Override
    public void generateSymbolNode(Node symbolNode) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
