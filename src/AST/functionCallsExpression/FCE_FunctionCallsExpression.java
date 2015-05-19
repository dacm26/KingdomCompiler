/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AST.functionCallsExpression;

import AST.parameterList.*;
import app.semanticAnalysis.Table.Node;

/**
 *
 * @author C5220701
 */
public class FCE_FunctionCallsExpression extends functionCallsExpression {

    private String id;
    private parameterList pL;

    public FCE_FunctionCallsExpression(String id, parameterList pL) {
        this.id = id;
        this.pL = pL;
    }

    public FCE_FunctionCallsExpression(String id) {
        this.id = id;
        this.pL=null;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public parameterList getpL() {
        return pL;
    }

    public void setpL(parameterList pL) {
        this.pL = pL;
    }

    @Override
    public void printNode() {
        System.out.println("FCE_FunctionCallsExpression");
        System.out.println(this.id);
        if (this.pL != null) {
            this.pL.printNode();

        }
    }

    @Override
    public void generateSymbolNode(Node symbolNode) {
        
    }

}
