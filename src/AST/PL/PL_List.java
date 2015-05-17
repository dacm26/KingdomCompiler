/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AST.PL;
import AST.Expression.*;
/**
 *
 * @author Daniel
 */
public class PL_List extends parameterList{
    private parameterList pL;
    private Expression exp;

    public PL_List(parameterList pL, Expression exp) {
        this.pL = pL;
        this.exp = exp;
    }

    public parameterList getpL() {
        return pL;
    }

    public void setpL(parameterList pL) {
        this.pL = pL;
    }

    public Expression getType() {
        return exp;
    }

    public void setType(Expression exp) {
        this.exp = exp;
    }


    @Override
    public void printNode() {
    }
    
    
}
