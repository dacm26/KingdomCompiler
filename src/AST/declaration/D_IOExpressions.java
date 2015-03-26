/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AST.declaration;
import AST.ioExpressions.*;
/**
 *
 * @author C5220701
 */
public class D_IOExpressions extends declaration{
    private ioExpressions ioE;

    public D_IOExpressions(ioExpressions ioE) {
        this.ioE = ioE;
    }

    public ioExpressions getIoE() {
        return ioE;
    }

    public void setIoE(ioExpressions ioE) {
        this.ioE = ioE;
    }

    @Override
    public void printNode() {
        System.out.println("D_IOExpressions");
        this.ioE.printNode();
    }
    
}
