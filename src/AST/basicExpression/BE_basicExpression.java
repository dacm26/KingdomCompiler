/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AST.basicExpression;

/**
 *
 * @author Daniel
 */
public class BE_basicExpression extends basicExpression{
    private basicExpression bE;

    public BE_basicExpression(basicExpression bE) {
        this.bE = bE;
    }

    public basicExpression getbE() {
        return bE;
    }

    public void setbE(basicExpression bE) {
        this.bE = bE;
    }

    @Override
    public void printNode() {
        System.out.println("BE_basicExpression");
        this.bE.printNode();
    }
    
}
