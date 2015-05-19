/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AST.relationalExpression;
import AST.additiveExpression.*;
import app.semanticAnalysis.Table.Node;
/**
 *
 * @author Daniel
 */
public class RE_additiveExpression extends relationalExpression{
    private additiveExpression aE;

    public RE_additiveExpression(additiveExpression aE) {
        this.aE = aE;
    }

    public additiveExpression getaE() {
        return aE;
    }

    public void setaE(additiveExpression aE) {
        this.aE = aE;
    }

    @Override
    public void printNode() {
        System.out.println("RE_additiveExpression");
        this.aE.printNode();
    }

    @Override
    public void generateSymbolNode(Node symbolNode) {
        
    }
    
    
}
