/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AST.multiplicativeExpression;
import AST.basicExpression.*;
import app.semanticAnalysis.Table.Node;
/**
 *
 * @author Daniel
 */
public class ME_basicExpression extends multiplicativeExpression{
    private basicExpression bE;

    public ME_basicExpression(basicExpression bE) {
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
        System.out.println("ME_basicExpression");
        this.bE.printNode();
    }

    @Override
    public void generateSymbolNode(Node symbolNode) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
