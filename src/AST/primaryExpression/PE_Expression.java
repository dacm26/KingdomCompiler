/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AST.primaryExpression;

import AST.expression.Expression;
import app.semanticAnalysis.Table.Node;

/**
 *
 * @author Daniel
 */
public class PE_Expression extends primaryExpression{
    private Expression expression;

    public PE_Expression(Expression expression) {
        this.expression = expression;
    }

    public Expression getExpression() {
        return expression;
    }

    public void setExpression(Expression expression) {
        this.expression = expression;
    }

    @Override
    public void printNode() {
    }

    @Override
    public int getType(Node symbolTable) {
        return this.expression.getExpressionType(symbolTable);
    }


    
}
