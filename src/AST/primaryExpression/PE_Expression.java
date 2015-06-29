/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AST.primaryExpression;

import AST.expression.Expression;
import app.intermediateCode.Generate;
import app.semanticAnalysis.Table.Node;

/**
 *
 * @author Daniel
 */
public class PE_Expression extends primaryExpression{
    private Expression expression;
    private String stringContent;
    private int result;
    private Generate generateCode;

    public PE_Expression(Expression expression,Generate generateCode) {
        this.expression = expression;
        this.generateCode = generateCode;
        this.setStringContent();
    }

    public Expression getExpression() {
        return expression;
    }

    public void setExpression(Expression expression) {
        this.expression = expression;
    }

    public void setStringContent(){
        this.stringContent = expression.getStringContent();
    }

    public String getStringContent(){
        return this.stringContent;
    }
    
    @Override
    public void generateIC(){
    }

    @Override
    public void printNode() {
    }

    @Override
    public int getType(Node symbolTable) {
        return this.expression.getExpressionType(symbolTable);
    }


    
}
