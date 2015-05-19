/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AST.statement;
import AST.iterationStatement.iterationStatement;
import AST.iterationStatement.*;
import app.semanticAnalysis.Table.Node;
/**
 *
 * @author Daniel
 */
public class S_IterationStatement extends Statement{
    private iterationStatement iS;

    public S_IterationStatement(iterationStatement iS) {
        this.iS = iS;
    }

    public iterationStatement getiS() {
        return iS;
    }

    public void setiS(iterationStatement iS) {
        this.iS = iS;
    }

    @Override
    public void printNode() {
        System.out.println("S_IterationStatement");
        this.iS.printNode();
    }

    @Override
    public void generateSymbolNode(Node symbolNode) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
