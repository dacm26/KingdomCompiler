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
public class PL_ExpressionList extends parameterList {

    private Expression exp;
    private parameterList pL;
    private Generate generateCode;
    private ArrayList<RowIC> cER;
    
    public PL_ExpressionList(parameterList pL, Expression exp, Generate generateCode) {
        this.exp = exp;
        this.pL = pL;
        this.generateCode = generateCode;
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
    
    public parameterList getpL() {
        return pL;
    }
    
    public void setpL(parameterList pL) {
        this.pL = pL;
    }
    
    @Override
    public void generateIC(){
        pL.generateIC();
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
        return this.exp.getExpressionType(symbolNode) != -1 && this.pL.validExpression(symbolNode);
    }
    
    @Override
    public ArrayList<Integer> getTypes(Node symbolNode) {
        ArrayList<Integer> tmp = this.pL.getTypes(symbolNode);
        tmp.add(this.exp.getExpressionType(symbolNode));
        return tmp;
    }
    
}
