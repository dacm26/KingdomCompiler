/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AST.expression;

import AST.conditionalExpression.conditionalExpression;
import app.intermediateCode.Generate;
import app.semanticAnalysis.Table.Node;
import java.util.ArrayList;

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
    
    public void generateIC(Generate gc){
        
    }

}
