/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AST.statement;
import AST.selectionStatement.*;
import app.intermediateCode.Generate;
import app.semanticAnalysis.Table.Node;
/**
 *
 * @author Daniel
 */
public class S_SelectionStatement extends Statement{
    private selectionStatement sS;
    private Generate generateCode;

    public S_SelectionStatement(selectionStatement sS, Generate generateCode) {
        this.sS = sS;
        this.generateCode = generateCode;
    }

    public selectionStatement getsS() {
        return sS;
    }

    public void setsS(selectionStatement sS) {
        this.sS = sS;
    }

    @Override
    public void generateIC(){
        this.sS.generateIC();
    }
    
    @Override
    public void printNode() {
        System.out.println("S_SelectionStatement");
        this.sS.printNode();
    }

    @Override
    public void generateSymbolNode(Node symbolNode) {
        this.sS.generateSymbolNode(symbolNode);
    }
    
}
