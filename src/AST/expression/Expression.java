/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AST.expression;

import AST.conditionalExpression.*;
import app.intermediateCode.Generate;
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
    private Generate generateCode;

    public Expression(conditionalExpression ConditionalExpression) {
        this.ConditionalExpression = ConditionalExpression;
        this.setStringContent();
        System.out.println(stringContent);
        System.out.println(result);
    }

    public conditionalExpression getConditionalExpression() {
        return ConditionalExpression;
    }

    public void setConditionalExpression(conditionalExpression ConditionalExpression) {
        this.ConditionalExpression = ConditionalExpression;
    }

    public void generateIC(Generate gc){
        this.generateCode = gc;
    }

    public void setStringContent(){
        if (ConditionalExpression instanceof CE_equalityExpression){
            CE_equalityExpression cE = (CE_equalityExpression) ConditionalExpression;
            this.stringContent = cE.getStringContent();
            this.result = cE.getResult();
        } else {
            CE_Operation cE = (CE_Operation) ConditionalExpression;
            this.stringContent = cE.getStringContent();
            this.result = cE.getResult();
        }
    }

    public String getStringContent(){
        return this.stringContent;
    }

    public int getResult(){
        return result;
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

}
