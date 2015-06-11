/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AST.parameterList;

import AST.expression.*;
import app.semanticAnalysis.Table.Node;
import java.util.ArrayList;

/**
 *
 * @author Daniel
 */
public class PL_ExpressionList extends parameterList {

    private Expression exp;
    private parameterList pL;
    
    public PL_ExpressionList(parameterList pL, Expression exp) {
        this.exp = exp;
        this.pL = pL;
    }
    
    public Expression getExp() {
        return exp;
    }
    
    public void setExp(Expression exp) {
        this.exp = exp;
    }
    
    public parameterList getpL() {
        return pL;
    }
    
    public void setpL(parameterList pL) {
        this.pL = pL;
    }
    
    @Override
    public void printNode() {
    }
    
    @Override
    public void generateSymbolNode(Node symbolNode) {
        
    }
    
    @Override
    public boolean validExpression(Node symbolNode) {
        return this.exp.getExpressionType(symbolNode) != -1 && this.pL.validExpression(symbolNode);
    }
    
    @Override
    public ArrayList<Integer> getTypes(Node symbolNode) {
        ArrayList<Integer> tmp = this.pL.getTypes(symbolNode);
        tmp.add(this.exp.getExpressionType(symbolNode));
        return tmp;
    }
    
}
