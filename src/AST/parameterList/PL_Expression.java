/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AST.parameterList;

import AST.expression.*;
import app.intermediateCode.Generate;
import app.semanticAnalysis.Table.Node;
import java.util.ArrayList;

/**
 *
 * @author Daniel
 */
public class PL_Expression extends parameterList{
    private Expression exp;
    private Generate generateCode;

    public PL_Expression(Expression exp) {
        this.exp = exp;
    }

    public Expression getExp() {
        return exp;
    }

    public void setExp(Expression exp) {
        this.exp = exp;
    }
    
    @Override
    public void generateIC(){
    }

    @Override
    public void printNode() {
    }

    @Override
    public void generateSymbolNode(Node symbolNode) {
        
    }

    @Override
    public boolean validExpression(Node symbolNode) {
        return this.exp.getExpressionType(symbolNode) != -1;
    }

    @Override
    public ArrayList<Integer> getTypes(Node symbolNode) {
        ArrayList<Integer> tmp = new ArrayList();
        tmp.add(this.exp.getExpressionType(symbolNode));
        return tmp;
    }
    
}
