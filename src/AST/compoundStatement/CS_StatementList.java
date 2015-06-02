/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AST.compoundStatement;
import AST.statementList.*;
import app.semanticAnalysis.Table.Node;
/**
 *
 * @author Daniel
 */
public class CS_StatementList extends compoundStatement{
    private statementList sL = null;

    public CS_StatementList(statementList sL) {
        this.sL = sL;
    }

    public statementList getsL() {
        return sL;
    }

    public void setsL(statementList sL) {
        this.sL = sL;
    }

    @Override
    public void printNode() {
        System.out.println("CS_StatementList");
        this.sL.printNode();
    }

    @Override
    public void generateSymbolNode(Node symbolNode) {
        this.sL.generateSymbolNode(symbolNode);
    }
    
    
}
