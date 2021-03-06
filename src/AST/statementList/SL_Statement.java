/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AST.statementList;
import AST.statement.*;
import app.intermediateCode.Generate;
import app.semanticAnalysis.Table.Node;
/**
 *
 * @author Daniel
 */
public class SL_Statement extends statementList{
    private Statement stm;
    private Generate generateCode;

    public SL_Statement(Statement stm) {
        this.stm = stm;
    }

    public Statement getStm() {
        return stm;
    }

    public void setStm(Statement stm) {
        this.stm = stm;
    }

    @Override
    public void generateIC(Generate gc){
        this.generateCode = gc;
        this.stm.generateIC(this.generateCode); 
    }
    
    @Override
    public void printNode() {
        System.out.println("SL_Statement");
        this.stm.printNode();
    }

    @Override
    public void generateSymbolNode(Node symbolNode) {
        this.stm.generateSymbolNode(symbolNode);
    }
    
}
