/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AST.expression;

import AST.additiveExpression.AE_Operation;
import AST.additiveExpression.AE_multiplicativeExpression;
import AST.additiveExpression.additiveExpression;
import AST.basicExpression.BE_primaryExpression;
import AST.conditionalExpression.CE_Operation;
import AST.conditionalExpression.CE_equalityExpression;
import AST.conditionalExpression.conditionalExpression;
import AST.equalityExpression.EE_relationalExpression;
import AST.multiplicativeExpression.ME_Operation;
import AST.multiplicativeExpression.ME_basicExpression;
import AST.primaryExpression.PE_Content;
import AST.primaryExpression.PE_Expression;
import AST.primaryExpression.PE_Id;
import AST.relationalExpression.RE_additiveExpression;
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

    public int getExpressionType(Node symbolNode) {
        /*
         char = 1
         int = 2
         double = 3
         string = 4
         boolean = 5
         error = -1
         */
        if (this.ConditionalExpression instanceof CE_equalityExpression) {
            /*No es un boolean*/
            if (((CE_equalityExpression) this.ConditionalExpression).geteE() instanceof EE_relationalExpression) {
                /*No es un boolean*/
                EE_relationalExpression temp = ((EE_relationalExpression) ((CE_equalityExpression) this.ConditionalExpression).geteE());
                if (((EE_relationalExpression) temp).getrE() instanceof RE_additiveExpression) {    
                    /*No es un boolean*/

                } else {
                    /*Es una operacion booleana*/
                    return 5;
                }
            } else {
                /*Es una operacion booleana*/
                return 5;
            }
        } else if (this.ConditionalExpression instanceof CE_Operation) {
            /*Es una operacion booleana*/
            return 5;
        }
        /*No es nada*/
        System.err.println("Error, Type mismatch");
        return -1;

    }

}
