/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AST.equalityExpression;
import AST.relationalExpression.*;
/**
 *
 * @author Daniel
 */
public class EE_relationalExpression extends equalityExpression{
    private relationalExpression rE;

    public EE_relationalExpression(relationalExpression rE) {
        this.rE = rE;
    }

    public relationalExpression getrE() {
        return rE;
    }

    public void setrE(relationalExpression rE) {
        this.rE = rE;
    }

    @Override
    public void printNode() {
        System.out.println("EE_relationalExpression");
        this.rE.printNode();
    }
    
}
