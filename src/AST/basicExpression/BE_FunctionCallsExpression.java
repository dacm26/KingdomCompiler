/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AST.basicExpression;
import AST.functionCallsExpression.*;
/**
 *
 * @author C5220701
 */
public class BE_FunctionCallsExpression extends basicExpression{
    private functionCallsExpression fCE;

    public BE_FunctionCallsExpression(functionCallsExpression fCE) {
        this.fCE = fCE;
    }
    
    
    public functionCallsExpression getfCE() {
        return fCE;
    }

    public void setfCE(functionCallsExpression fCE) {
        this.fCE = fCE;
    }

    @Override
    public void printNode() {
        System.out.println("BE_FunctionCallsExpression");
        this.fCE.printNode();
    }
    
    
}
