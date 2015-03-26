/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AST.functionCallsExpression;

import AST.identifierList.*;

/**
 *
 * @author C5220701
 */
public class FCE_FunctionCallsExpression extends functionCallsExpression {

    private String id;
    private identifierList iL;

    public FCE_FunctionCallsExpression(String id, identifierList iL) {
        this.id = id;
        this.iL = iL;
    }

    public FCE_FunctionCallsExpression(String id) {
        this.id = id;
        this.iL=null;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public identifierList getiL() {
        return iL;
    }

    public void setiL(identifierList iL) {
        this.iL = iL;
    }

    @Override
    public void printNode() {
        System.out.println("FCE_FunctionCallsExpression");
        System.out.println(this.id);
        if (this.iL != null) {
            this.iL.printNode();

        }
    }

}
