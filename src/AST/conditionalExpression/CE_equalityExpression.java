/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AST.conditionalExpression;
import AST.equalityExpression.*;
import app.semanticAnalysis.Table.Node;
import java.util.ArrayList;
/**
 *
 * @author Daniel
 */
public class CE_equalityExpression extends conditionalExpression{
    private equalityExpression eE;

    public CE_equalityExpression(equalityExpression eE) {
        this.eE = eE;
    }

    public equalityExpression geteE() {
        return eE;
    }

    public void seteE(equalityExpression eE) {
        this.eE = eE;
    }

    @Override
    public void printNode() {
        System.out.println("CE_equalityExpression");
        this.eE.printNode();
    }


    @Override
    public ArrayList<Integer> getType(Node symbolTable) {
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(this.eE.getType(symbolTable));
        return temp;
    }
    
}
