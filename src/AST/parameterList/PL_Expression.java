/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AST.parameterList;

import AST.expression.*;
import app.intermediateCode.Generate;
import app.intermediateCode.RowIC;
import app.semanticAnalysis.Table.Node;
import java.util.ArrayList;

/**
 *
 * @author Daniel
 */
public class PL_Expression extends parameterList{
    private Expression exp;
    private Generate generateCode;
    private ArrayList<RowIC> cER;

    public PL_Expression(Expression exp, Generate generateCode) {
        this.exp = exp;
        exp.generateIC();
        this.cER = new ArrayList<RowIC>(this.generateCode.getCodeBlock());
        this.generateCode.emptyTemp();
        this.exp.setCodeBlock(cER);
    }

    public Expression getExp() {
        return exp;
    }

    public void setExp(Expression exp) {
        this.exp = exp;
    }
    
    @Override
    public void generateIC(){
        this.generateCode.flushCodeBlock(exp.getCodeBlock());
        this.generateCode.generateParameter(this.exp.getStringContent());
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
