/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AST.declaration;
import AST.functionCallsExpression.*;
/**
 *
 * @author C5220701
 */
public class D_FunctionCallsExpression extends declaration{
    private functionCallsExpression fCE;

    public D_FunctionCallsExpression(functionCallsExpression fCE) {
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
        System.out.println("D_FunctionCallsExpression");
        this.fCE.printNode();
    }
    
    
}
