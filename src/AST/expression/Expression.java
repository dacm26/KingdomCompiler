/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AST.expression;

import AST.conditionalExpression.*;
import app.intermediateCode.Generate;
import app.intermediateCode.RowIC;
import app.semanticAnalysis.Table.Node;
import java.util.ArrayList;

/**
 *
 * @author Daniel
 */
public class Expression {

    private conditionalExpression ConditionalExpression;
    private String stringContent;
    private int result;
    private int line;
    private Generate generateCode;
    private ArrayList<RowIC> row;

    public Expression(conditionalExpression ConditionalExpression, Generate generateCode) {
        this.ConditionalExpression = ConditionalExpression;
        this.generateCode = generateCode;
    }

    public conditionalExpression getConditionalExpression() {
        return ConditionalExpression;
    }

    public ArrayList<RowIC> getCodeBlock(){
        return row;
    }

    public void setCodeBlock(ArrayList<RowIC> t){
        row = t;
    }

    public void setConditionalExpression(conditionalExpression ConditionalExpression) {
        this.ConditionalExpression = ConditionalExpression;
    }

    public void generateIC(){
        ConditionalExpression.generateIC();
        this.setStringContent();
    }

    public void setStringContent(){
        if (ConditionalExpression instanceof CE_equalityExpression){
            CE_equalityExpression cE = (CE_equalityExpression) ConditionalExpression;
            this.stringContent = cE.getStringContent();
        } else {
            CE_Operation cE = (CE_Operation) ConditionalExpression;
            this.stringContent = cE.getStringContent();
        }
    }

    public String getStringContent(){
        return this.stringContent;
    }

    public int getResult(){
        return result;
    }
    public void generateConstants(Node symbolNode){
        this.ConditionalExpression.generateConstants(symbolNode);
    }
    
    public int getExpressionType(Node symbolNode) {
        /*
         char = 1
         int = 2
         double = 3
         string = 4
         boolean = 5
         error = -1
         */
        ArrayList<Integer> types = this.ConditionalExpression.getType(symbolNode);
        if (types.size() != 1) {
            for (Integer type : types) {
                if (type == -1) {
                    return -1;
                }else if(type == 5){
                    return 5;
                }
            }
            return types.get(0);
            
        }else if(types.size() == 1){
            return types.get(0);
        }else{
            return -1;
        }
    }
    public void setLine(int line) {
        this.line = line+1;
    }

    public int getLine() {
        return this.line;
    }
    
}


