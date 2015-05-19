/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AST.jumpStatement;
import AST.conditionalExpression.*;
import app.semanticAnalysis.Table.Node;
/**
 *
 * @author Daniel
 */
public class JS_Return extends jumpStatement{
    private conditionalExpression cE;
    public JS_Return() {
        cE=null;
    }

    public JS_Return(conditionalExpression cE) {
        this.cE = cE;
    }

    public conditionalExpression getcE() {
        return cE;
    }

    public void setcE(conditionalExpression cE) {
        this.cE = cE;
    }
    

    @Override
    public void printNode() {
        System.out.println("JS_Return");
        if (this.cE != null) {
            this.cE.printNode();
        }
    }

    @Override
    public void generateSymbolNode(Node symbolNode) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
