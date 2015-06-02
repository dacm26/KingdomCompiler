/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AST.statementList;
import AST.statement.*;
import app.semanticAnalysis.Table.Node;
/**
 *
 * @author Daniel
 */
public class SL_StatementList extends statementList{
    private statementList sL=null;
    private Statement stm;

    public SL_StatementList(statementList sL, Statement stm) {
        this.sL = sL;
        this.stm = stm;
    }

    public statementList getsL() {
        return sL;
    }

    public void setsL(statementList sL) {
        this.sL = sL;
    }

    public Statement getStm() {
        return stm;
    }

    public void setStm(Statement stm) {
        this.stm = stm;
    }

    @Override
    public void printNode() {
        System.out.println("SL_StatementList");
        this.sL.printNode();
        this.stm.printNode();
    }

    @Override
    public void generateSymbolNode(Node symbolNode) {
        this.sL.generateSymbolNode(symbolNode);
        this.stm.generateSymbolNode(symbolNode);
    }
    
    
}
