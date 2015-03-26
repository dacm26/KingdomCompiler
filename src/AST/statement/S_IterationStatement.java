/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AST.statement;
import AST.iterationStatement.iterationStatement;
import AST.iterationStatement.*;
/**
 *
 * @author Daniel
 */
public class S_IterationStatement extends statement{
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
    
}
