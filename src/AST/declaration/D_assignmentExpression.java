/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AST.declaration;
import AST.assignmentExpression.*;
/**
 *
 * @author Daniel
 */
public class D_assignmentExpression extends declaration{
    private assignmentExpression aE;

    public D_assignmentExpression(assignmentExpression aE) {
        this.aE = aE;
    }

    public assignmentExpression getaE() {
        return aE;
    }

    public void setaE(assignmentExpression aE) {
        this.aE = aE;
    }

    @Override
    public void printNode() {
        System.out.println("D_assignmentExpression");
        this.aE.printNode();
    }
    
}
