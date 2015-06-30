/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AST.statement;

import AST.ioExpressions.*;
import app.intermediateCode.Generate;
import app.semanticAnalysis.Table.Node;
/**
 *
 * @author Daniel
 */
public class S_IOExpression extends Statement{
    private ioExpressions ioExp;
    private Generate generateCode;

    public S_IOExpression(ioExpressions ioExp, Generate gc) {
        this.generateCode = gc;
        this.ioExp = ioExp;
    }

    public ioExpressions getIoExp() {
        return ioExp;
    }

    public void setIoExp(ioExpressions ioExp) {
        this.ioExp = ioExp;
    }

    @Override
    public void generateIC(){
        ioExp.generateIC(generateCode);
    }
    
    @Override
    public void printNode() {
    }

    @Override
    public void generateSymbolNode(Node symbolNode) {
        this.ioExp.generateSymbolNode(symbolNode);
        
    }
    

    
@Override
    public void setLine(int line) {
        this.line = line+1;
    }

    @Override
    public int getLine() {
        return this.line;
    }
    
}
