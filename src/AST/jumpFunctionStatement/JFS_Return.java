/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AST.jumpFunctionStatement;

import AST.conditionalExpression.conditionalExpression;

/**
 *
 * @author Daniel
 */
public class JFS_Return extends jumpFunctionStatement{
    private conditionalExpression cS;

    public JFS_Return(conditionalExpression cS) {
        this.cS = cS;
    }

    public conditionalExpression getcS() {
        return cS;
    }

    public void setcS(conditionalExpression cS) {
        this.cS = cS;
    }
    
    @Override
    public void printNode() {
    }
    
}
