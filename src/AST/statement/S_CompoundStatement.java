/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AST.statement;
import AST.compoundStatement.*;
import app.intermediateCode.Generate;
import app.semanticAnalysis.Table.Node;
/**
 *
 * @author Daniel
 */
public class S_CompoundStatement extends Statement{
    private compoundStatement cS;

    public S_CompoundStatement(compoundStatement cS) {
        this.cS = cS;
    }

    public compoundStatement getcS() {
        return cS;
    }

    public void setcS(compoundStatement cS) {
        this.cS = cS;
    }
    
    @Override
    public void generateIC(){
        this.cS.generateIC();
    }

    @Override
    public void printNode() {
        System.out.println("S_CompoundStatement");
        this.cS.printNode();
    }

    @Override
    public void generateSymbolNode(Node symbolNode) {
        this.cS.generateSymbolNode(symbolNode);
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
