/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AST.statement;
import AST.compoundStatement.*;
/**
 *
 * @author Daniel
 */
public class S_CompoundStatement extends statement{
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
    public void printNode() {
        System.out.println("S_CompoundStatement");
        this.cS.printNode();
    }
    
}
