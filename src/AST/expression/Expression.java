/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AST.expression;

import AST.conditionalExpression.conditionalExpression;
import app.semanticAnalysis.Table.Node;
/**
 *
 * @author Daniel
 */ 
public class Expression {
    private conditionalExpression ConditionalExpression;

    public Expression(conditionalExpression ConditionalExpression) {
        this.ConditionalExpression = ConditionalExpression;
    }

    public conditionalExpression getConditionalExpression() {
        return ConditionalExpression;
    }

    public void setConditionalExpression(conditionalExpression ConditionalExpression) {
        this.ConditionalExpression = ConditionalExpression;
    }
    public void generateSymbolNode(Node table){
        
    }
}
